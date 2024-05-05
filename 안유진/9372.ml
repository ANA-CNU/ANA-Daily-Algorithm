let rec unbounding n =
  match n with
  | 0 -> ()
  | _ -> (
    let (_, _) = Scanf.scanf "%d %d\n" (fun a b -> (a, b)) in
    unbounding (n - 1)
  )

let rec testcases t =
  match t with
  | 0 -> ()
  | _ -> (
    let (n, m) = Scanf.scanf "%d %d\n" (fun a b -> (a, b)) in
    let _ = unbounding m in
    let _ = Format.printf "%d\n" (n - 1) in 
    testcases (t - 1)
  )

let t = Scanf.scanf "%d\n" (fun a -> a)
let _ = testcases t
