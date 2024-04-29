import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Stack;

class LexingException extends RuntimeException {}
class ParsingException extends RuntimeException {}
class UnreachableException extends RuntimeException {}

interface token {}
interface ex {}
interface stack_elem {}

enum state { Q0, Q1, Q2, Q3 }
enum oper { ADD, SUB, MUL, DIV }

class TO implements token {
    public char o;
    public TO(char o) {this.o = o;}
}
class TI implements token {
    public String n;
    public TI(String n) {this.n = n; }
}
class TL implements token {}
class TR implements token {}

class E implements ex {
    public oper o;
    public ex e1;
    public ex e2;
    public E(oper o, ex e1, ex e2) {this.o = o; this.e1 = e1; this.e2 = e2;}
}
class Num implements ex {
    public String n;
    public Num(String n) {this.n = n;}
}

class Expr implements stack_elem {
    public ex e;
    public Expr(ex e) {this.e = e;}
}
class Op implements stack_elem {
    public oper o;
    public Op(oper o) {this.o = o;}
}
class LP implements stack_elem {}
class RP implements stack_elem {}

public class Main {
    public static final state Q0 = state.Q0;
    public static final state Q1 = state.Q1;
    public static final state Q2 = state.Q2;
    public static final state Q3 = state.Q3;

    public static final oper ADD = oper.ADD;
    public static final oper SUB = oper.SUB;
    public static final oper MUL = oper.MUL;
    public static final oper DIV = oper.DIV;

    public static final TR TR = new TR();
    public static final TL TL = new TL();

    public static final LP LP = new LP();
    public static final RP RP = new RP();

    public static ArrayList<token> lex(ArrayList<token> bf1, String bf2, state stt, String acc) {
        if (bf2.isEmpty()) {
            if (stt == Q0) {
                throw new LexingException();
            } else if (stt == Q1) {
                bf1.add(new TI(acc));
                return bf1;
            } else {
                return bf1;
            }
        } else {
            char h = bf2.charAt(0);
            String t = bf2.substring(1,bf2.length());

            if (stt == Q0) {
                if (h == '(') {
                    bf1.add(new TL());
                    return lex(bf1, t, Q0, "");
                } else if ('0' <= h && h <= '9') {
                    return lex(bf1, t, Q1, acc+h);
                } else {
                    throw new LexingException();
                }
            } else if (stt == Q1) {
                if (h == ')') {
                    bf1.add(new TI(acc));
                    bf1.add(TR);
                    return lex(bf1, t, Q2, "");
                } else if ('0' <= h && h <= '9') {
                    return lex(bf1, t, Q1, acc+h);
                } else if (h == '+' || h == '-' || h == '*' || h == '/') {
                    bf1.add(new TI(acc));
                    bf1.add(new TO(h));
                    return lex(bf1, t, Q3, "");
                } else {
                    throw new LexingException();
                }
            } else if (stt == Q2) {
                if (h == ')') {
                    bf1.add(TR);
                    return lex(bf1, t, Q2, "");
                } else if (h == '+' || h == '-' || h == '*' || h == '/') {
                    bf1.add(new TO(h));
                    return lex(bf1, t, Q3, "");
                } else {
                    throw new LexingException();
                }
            } else {
                if (h == '(') {
                    bf1.add(TL);
                    return lex(bf1, t, Q3, "");
                } else if ('0' <= h && h <= '9') {
                    return lex(bf1, t, Q1, ""+h);
                } else {
                    throw new LexingException();
                }
            }
        }
    }

    // true : reduce
    public static boolean reduceOrShift(Stack<stack_elem> temp, stack_elem lookahead) {
        Stack<stack_elem> st = new Stack<>();
        for (stack_elem ele : temp) {
            st.push(ele);
        }

        if (st.isEmpty()) {
            throw new UnreachableException();
        } else {
            stack_elem top = st.peek();
            st.pop();
            if (top instanceof RP) {
                return true;
            } else {
                if (st.isEmpty()) {
                    return false;
                } else {
                    stack_elem cur_op = st.peek();
                    if (cur_op instanceof LP) {
                        return false;
                    } else if (cur_op instanceof Op && (((Op) cur_op).o == ADD || ((Op) cur_op).o == SUB)) {
                        if (lookahead instanceof Op && (((Op) lookahead).o == MUL || ((Op) lookahead).o == DIV)) {
                            return false;
                        } else {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }
        }
    }

    public static Stack<stack_elem> reduce(Stack<stack_elem> st) {
        if (st.isEmpty()) {
            throw new UnreachableException();
        } else {
            stack_elem top = st.peek();
            st.pop();
            if (st.isEmpty()) {
                throw new UnreachableException();
            } else {
                stack_elem pre = st.peek();
                st.pop();
                if (st.isEmpty()) {
                    throw new ParsingException();
                } else {
                    stack_elem ppre = st.peek();
                    st.pop();
                    if (ppre instanceof Expr && pre instanceof Op && top instanceof Expr) {
                        st.push(new Expr(new E(((Op) pre).o, ((Expr) ppre).e, ((Expr) top).e)));
                        return st;
                    } else if (ppre instanceof LP && pre instanceof Expr && top instanceof RP) {
                        st.push(pre);
                        return st;
                    } else {
                        throw new ParsingException();
                    }
                }
            }
        }
    }

    public static stack_elem _parse(ArrayList<token> token_lst, int idx, Stack<stack_elem> st) {
        if (idx == token_lst.size()) {
            if (st.isEmpty()) {
                throw new UnreachableException();
            } else {
                stack_elem top = st.peek();
                if (st.size() == 1) {
                    return top;
                } else {
                    return _parse(token_lst, idx, reduce(st));
                }
            }
        } else {
            token h = token_lst.get(idx);
            if (h instanceof TI) {
                st.push(new Expr(new Num(((TI) h).n)));
                return _parse(token_lst, idx+1, st);
            } else if (h instanceof TO) {
                Op o;
                if (((TO) h).o == '+') {
                    o = new Op(ADD);
                } else if (((TO) h).o == '-') {
                    o = new Op(SUB);
                } else if (((TO) h).o == '*') {
                    o = new Op(MUL);
                } else if (((TO) h).o == '/') {
                    o = new Op(DIV);
                } else {
                    throw new UnreachableException();
                }
                boolean flag = reduceOrShift(st, o);
                if (flag) {
                    return _parse(token_lst, idx, reduce(st));
                } else {
                    st.push(o);
                    return _parse(token_lst, idx+1, st);
                }
            } else if (h instanceof TL) {
                st.push(LP);
                return _parse(token_lst, idx+1, st);
            } else if (h instanceof TR) {
                boolean flag = reduceOrShift(st, RP);
                if (flag) {
                    return _parse(token_lst, idx, reduce(st));
                } else {
                    st.push(RP);
                    return _parse(token_lst, idx+1, st);
                }
            } else {
                throw new UnreachableException();
            }
        }
    }

    public static ex parse(ArrayList<token> token_lst) {
        stack_elem result = _parse(token_lst, 0, new Stack<stack_elem>());
        if (result instanceof Expr) {
            return ((Expr) result).e;
        } else {
            throw new UnreachableException();
        }
    }

    public static BigInteger interp(ex e) {
        if (e instanceof Num) {
            return new BigInteger(((Num) e).n);
        } else if (e instanceof E) {
            oper o = ((E) e).o;
            BigInteger n1 = interp(((E) e).e1);
            BigInteger n2 = interp(((E) e).e2);
            if (o == ADD) {
                return n1.add(n2);
            } else if (o == SUB) {
                return n1.subtract(n2);
            } else if (o == MUL) {
                return n1.multiply(n2);
            } else if (o == DIV) {
                if (n2.equals(BigInteger.ZERO)) {
                    throw new ArithmeticException();
                } else {
                    return n1.divide(n2);
                }
            } else {
                throw new UnreachableException();
            }
        } else {
            throw new UnreachableException();
        }
    }

    public static void printTokenList(ArrayList<token> token_lst) {
        for (token t : token_lst) {
            if (t instanceof TO) {
                System.out.print(((TO) t).o + " ");
            } else if (t instanceof TI) {
                System.out.print(((TI) t).n + " ");
            } else if (t instanceof TL) {
                System.out.print("TL ");
            } else if (t instanceof TR) {
                System.out.println("TR ");
            } else {
                throw new UnreachableException();
            }
        }
    }

    public static void printExpr(ex e) {
        if (e instanceof Num) {
            System.out.print(((Num) e).n);
        } else if (e instanceof E) {
            System.out.print(((E) e).o + " (");
            printExpr(((E) e).e1);
            System.out.print(", ");
            printExpr(((E) e).e2);
            System.out.print(")");
        } else {
            throw new UnreachableException();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        try {
            ArrayList<token> token_lst = lex(new ArrayList<token>(), s, Q0, "");
            ex e = parse(token_lst);
            System.out.println(interp(e).toString());
        } catch (Exception e) {
            System.out.println("ROCK");
        }
    }
}