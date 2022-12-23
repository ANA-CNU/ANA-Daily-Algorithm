import java.io.*;
import java.util.*;

class Hero{
    int x;
    int y;
    int hp;
    int damege;
    int defence;
    int level;
    int exp;
    int weapon;
    int sheid;


    HashSet<String> acc = new HashSet<>();
}

class Monster{
    String name;
    int attack;
    int defence;
    int maxHp;
    int currentHp;
    int exp;

    Monster(String n, int a, int d, int m, int e) {
        name = n;
        attack = a;
        defence = d;
        maxHp = m;
        exp = e;
    }
}

class Item {
    String type;
    String what;

    Item(String t, String w) {
        type = t;
        what = w;
    }
}

public class Main {
    static int N, M, turn;
    static int startX, startY, maxHP;
    static String map[][];
    static Monster mon[][];
    static Item item[][];

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static Hero hero;
    public static boolean checkingAcc(String acc) {
        return hero.acc.contains(acc);
    }

    public static void acc(String which) {
        if(which.equals("HR")) {
            hero.hp += 3;
        }
        if(which.equals("RE")) {
            hero.hp = maxHP;

            if(map[hero.x][hero.y].equals("&") || map[hero.x][hero.y].equals("M")) {
                mon[hero.x][hero.y].currentHp = mon[hero.x][hero.y].maxHp;
            }

            hero.x = startX;
            hero.y = startY;

            hero.acc.remove("RE");
        }
    }

    public static void levelUp(int exp) {
        if(hero.exp + exp >= (5 * hero.level)) {
            hero.level++;
            hero.exp = 0;

            maxHP += 5;
            hero.hp = maxHP;
            hero.damege += 2;
            hero.defence += 2;

        }else{
            hero.exp += exp;
        }
    }

    public static void heroWin() {
        if(checkingAcc("EX")) {
            int tempExp = mon[hero.x][hero.y].exp;
            tempExp *= (1.2);
            levelUp(tempExp);
        }else{
            levelUp(mon[hero.x][hero.y].exp);
        }

        if(checkingAcc("HR")) {
            acc("HR");
            if(hero.hp > maxHP) {
                hero.hp = maxHP;
            }
        }
        map[hero.x][hero.y] = ".";
    }

    public static void heroBattle(boolean first) {
        if(first){
            if(checkingAcc("CO")){
                if(checkingAcc("DX")){
                    mon[hero.x][hero.y].currentHp -= (Math.max(1, (hero.damege + hero.weapon) * 3 - (mon[hero.x][hero.y].defence)));
                }else{
                    mon[hero.x][hero.y].currentHp -= (Math.max(1, (hero.damege + hero.weapon) * 2 - (mon[hero.x][hero.y].defence)));
                }
            }
        }else{
            mon[hero.x][hero.y].currentHp -= (Math.max(1, (hero.damege + hero.weapon) - (mon[hero.x][hero.y].defence)));
        }
    }

    public static void monBattle() {
        hero.hp -= Math.max(1, mon[hero.x][hero.y].attack - (hero.defence + hero.sheid));
    }

    public static boolean monDie() {
        return mon[hero.x][hero.y].currentHp <= 0;
    }

    public static boolean playerDie(){
        return hero.hp <= 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = 0;
        int L = 0;

        map = new String[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {

                map[i][j] = String.valueOf(s.charAt(j));

                if(map[i][j].equals("&") || map[i][j].equals("M")) {
                    K++;
                }
                if(map[i][j].equals("B")) {
                    L++;
                }
                if(map[i][j].equals("@")) {
                    hero = new Hero();
                    hero.x = i;
                    hero.y = j;
                    startX = i;
                    startY = j;
                    map[i][j] = ".";
                }
            }
        }

        String movement = br.readLine();

        mon = new Monster[N][M];
        while (K --> 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            String name = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int maxhp = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());

            mon[r][c] = new Monster(name, a, d, maxhp, ex);
            mon[r][c].currentHp = maxhp;
        }

        item = new Item[N][M];
        while (L --> 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            String t = st.nextToken();
            String s = st.nextToken();

            item[r][c] = new Item(t, s);
        }
        //input end

        maxHP = 20;
        hero.exp = 0;
        hero.hp = 20;
        hero.damege = 2;
        hero.defence = 2;
        hero.level = 1;
        hero.weapon = 0;
        hero.sheid = 0;

        turn = 0;
        boolean hpZeroTrap = false;
        boolean monsterZero = false;
        boolean heroFinalWin = false;
        boolean alive = true;

        for(int i = 0; i < movement.length(); i++) {
            String current = String.valueOf(movement.charAt(i));
            turn++;

            int currentX = hero.x;
            int currentY = hero.y;

            if(current.equals("L")) {
                hero.x += dx[0];
                hero.y += dy[0];
            }else if(current.equals("R")){
                hero.x += dx[1];
                hero.y += dy[1];
            }else if(current.equals("U")) {
                hero.x += dx[2];
                hero.y += dy[2];
            }else if(current.equals("D")) {
                hero.x += dx[3];
                hero.y += dy[3];
            }

            if(hero.x < 0 || hero.x >= N || hero.y < 0 || hero.y >= M) {
                hero.x = currentX;
                hero.y = currentY;
            }

            if(map[hero.x][hero.y].equals("#")) {
                hero.x = currentX;
                hero.y = currentY;
            }

            if(map[hero.x][hero.y].equals(".")){
                continue;
            }

            if(map[hero.x][hero.y].equals("B")) {
                if(item[hero.x][hero.y].type.equals("W") || item[hero.x][hero.y].type.equals("A")) {
                    int s = Integer.parseInt(item[hero.x][hero.y].what);

                    if(item[hero.x][hero.y].type.equals("W")) {
                        hero.weapon = s;
                    }else{
                        hero.sheid = s;
                    }
                }else{
                    if((!checkingAcc(item[hero.x][hero.y].what)) && hero.acc.size() < 4) {
                        hero.acc.add(item[hero.x][hero.y].what);
                    }
                }

                map[hero.x][hero.y] = ".";
            }

            if(map[hero.x][hero.y].equals("&") || map[hero.x][hero.y].equals("M")) {

                if(map[hero.x][hero.y].equals("M")){
                    if(checkingAcc("HU")){
                        hero.hp = maxHP;
                    }
                }

                boolean bossFirstAttack = false;
                boolean first = false;
                boolean HeroWin = false;
                boolean revived = false;

                if(checkingAcc("CO")){
                    heroBattle(true);

                    if(monDie()){
                        HeroWin = true;
                    }

                    first = true;
                }

                if(!HeroWin) {
                    while (true) {
                        if(!first) {
                            heroBattle(false);

                            if(monDie()) {
                                break;
                            }
                        }
                        first = false;

                        monBattle();
                        if(checkingAcc("HU") && map[hero.x][hero.y].equals("M")){
                            if(!bossFirstAttack){
                                hero.hp = maxHP;
                            }
                            bossFirstAttack = true;
                        }

                        if(playerDie()){
                            if(checkingAcc("RE")){
                                acc("RE");
                                revived = true;
                            }else{
                                monsterZero = true;
                                alive = false;
                            }
                            break;
                        }
                    }
                }
                if(revived){
                    continue;
                }
                if(monsterZero){
                    break;
                }

                if(map[hero.x][hero.y].equals("M")) {
                    heroFinalWin = true;
                    heroWin();
                    break;
                }else{
                    heroWin();
                }
            }

            if(map[hero.x][hero.y].equals("^")) {
                if(checkingAcc("DX")){
                    hero.hp -= 1;
                }else{
                    hero.hp -= 5;
                }

                if(hero.hp <= 0) {
                    if(!checkingAcc("RE")){
                        hpZeroTrap = true;
                        alive = false;
                        break;
                    }else{
                        acc("RE");
                    }
                }
            }
        }

        if(hero.hp < 0) {
            hero.hp = 0;
        }

        if(alive){
            map[hero.x][hero.y] = "@";
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        sb.append("Passed Turns : ").append(turn).append('\n');
        sb.append("LV : ").append(hero.level).append('\n');
        sb.append("HP : ").append(hero.hp).append("/").append(maxHP).append('\n');
        sb.append("ATT : ").append(hero.damege).append("+").append(hero.weapon).append('\n');
        sb.append("DEF : ").append(hero.defence).append("+").append(hero.sheid).append('\n');
        sb.append("EXP : ").append(hero.exp).append("/").append(hero.level * 5).append('\n');

        if(hpZeroTrap) {
            sb.append("YOU HAVE BEEN KILLED BY SPIKE TRAP..").append('\n');
        }else if(monsterZero) {
            sb.append("YOU HAVE BEEN KILLED BY ").append(mon[hero.x][hero.y].name).append("..");
            sb.append('\n');
        }else if(heroFinalWin) {
            sb.append("YOU WIN!").append('\n');
        }else{
            sb.append("Press any key to continue.");
        }
        System.out.println(sb);
    }
}
