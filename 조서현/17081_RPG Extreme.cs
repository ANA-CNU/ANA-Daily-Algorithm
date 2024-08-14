using System.Text;

internal class Program
{
    public static int n, m, passedTurns = 0;
    public static bool bossDead = false;
    public static Monster? playerKiller;
    public static Space[,] map;
    public static Player player;
    public abstract class Space
    {
        public int x, y;
        public abstract char Symbol { get; }
    }

    public abstract class Item
    {
        private bool equiped;
        public abstract void Equip();
        public abstract void UnEquip();
        public class Weapon : Item
        {
            public int attack;
            public Weapon(int attack)
            {
                this.attack = attack;
            }

            public override void Equip()
            {
                if (!equiped)
                {
                    player.attack += attack;
                    equiped = true;
                }
                else
                {
                    throw new Exception("Already equiped");
                }
            }

            public override void UnEquip()
            {
                if (equiped)
                {
                    player.attack -= attack;
                    equiped = false;
                }
                else
                {
                    throw new Exception("Not equiped");
                }
            }
        }

        public class Shield : Item
        {
            public int defense;
            public Shield(int defense)
            {
                this.defense = defense;
            }

            public override void Equip()
            {
                if (!equiped)
                {
                    player.defense += defense;
                    equiped = true;
                }
                else
                {
                    throw new Exception("Already equiped");
                }
            }

            public override void UnEquip()
            {
                if (equiped)
                {
                    player.defense -= defense;
                    equiped = false;
                }
                else
                {
                    throw new Exception("Not equiped");
                }
            }
        }

    }

    [Flags]
    public enum Accessory
    {
        HR = 1, RE = 2, CO = 4, EX = 8, DX = 16, HU = 32, CU = 64
    }

    public enum Direction
    {
        Left, Right, Up, Down
    }

    class Blank : Space
    {
        public Blank(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public override char Symbol => '.';
    }

    class Wall : Space
    {
        public Wall(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public override char Symbol => '#';
    }

    class Box : Space
    {
        public Item item;
        public Accessory accessory;

        public Box(int x, int y, Item item)
        {
            this.x = x;
            this.y = y;
            this.item = item;
        }

        public Box(int x, int y, Accessory accessory)
        {
            this.x = x;
            this.y = y;
            this.accessory = accessory;
        }

        public override char Symbol => 'B';
    }

    class Trap : Space
    {
        public Trap(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public void Trigger()
        {
            if (player.accessories.HasFlag(Accessory.DX))
            {
                player.curHealth -= 1;
            }
            else
            {
                player.curHealth -= 5;
            }
        }

        public override char Symbol => '^';
    }

    public class Monster : Space
    {
        public string name;
        public int attack, defense, health, gainExp;

        public Monster(int x, int y, string name, int attack, int defense, int health, int gainExp)
        {
            this.x = x;
            this.y = y;
            this.name = name;
            this.attack = attack;
            this.defense = defense;
            this.health = health;
            this.gainExp = gainExp;
        }

        public override char Symbol => '&';
    }

    public class Boss : Monster
    {
        public Boss(int x, int y, string name, int attack, int defense, int health, int gainExp) : base(x, y, name, attack, defense, health, gainExp)
        {
        }

        public override char Symbol => 'M';
    }

    public class Player : Space
    {
        public int curHealth, maxHealth, attack, defense, exp, level, accesoryCnt, initX, initY;
        public Item.Weapon? weapon;
        public Item.Shield? shield;
        public Accessory accessories;

        public Player(int x, int y)
        {
            initX = this.x = x;
            initY = this.y = y;
            curHealth = maxHealth = 20;
            attack = defense = 2;
            level = 1;
        }

        public void GainExp(int gain)
        {
            if (accessories.HasFlag(Accessory.EX))
            {
                exp += (int)(gain * 1.2);
            }
            else
            {
                exp += gain;
            }
            if (exp >= level * 5)
            {
                level++;
                exp = 0;
                maxHealth += 5;
                curHealth = maxHealth;
                attack += 2;
                defense += 2;
            }
        }

        public void AddAccessory(Accessory accessory)
        {
            if (accesoryCnt < 4 && !accessories.HasFlag(accessory))
            {
                accessories |= accessory;
                accesoryCnt++;
            }
        }
        public void DiscardAccessory(Accessory accessory)
        {
            if (accessories.HasFlag(accessory))
            {
                accessories &= ~accessory;
                accesoryCnt--;
            }
        }

        public void Move(Direction direction)
        {
            int nx = x, ny = y;
            switch (direction)
            {
                case Direction.Left:
                    ny--;
                    break;
                case Direction.Right:
                    ny++;
                    break;
                case Direction.Up:
                    nx--;
                    break;
                case Direction.Down:
                    nx++;
                    break;
                default:
                    throw new ArgumentOutOfRangeException(nameof(direction), direction, null);
            }

            if (0 <= nx && 0 <= ny && nx < n && ny < m && map[nx, ny].GetType() != typeof(Wall))
            {
                x = nx;
                y = ny;
            }
        }

        public void Resurrect()
        {
            x = initX;
            y = initY;
            curHealth = maxHealth;
        }

        public bool Fight(Monster mob)
        {
            if (mob is Boss && accessories.HasFlag(Accessory.HU)) curHealth = maxHealth;
            int turn = 0,
                monsterHealth = mob.health;
            while (true)
            {
                if (Dead()) return false;
                if (monsterHealth <= 0)
                {
                    GainExp(mob.gainExp);
                    return true;
                }
                // 플레이어 턴
                if (turn % 2 == 0)
                {
                    int at = attack;
                    if (turn == 0 && accessories.HasFlag(Accessory.CO))
                    {
                        if (accessories.HasFlag(Accessory.DX)) at *= 3;
                        else at *= 2;
                    }

                    monsterHealth -= Math.Max(at - mob.defense, 1);
                }
                // 몬스터 턴
                else
                {
                    if (turn == 1 && mob is Boss && accessories.HasFlag(Accessory.HU))
                    {

                    }
                    else
                    {
                        curHealth -= Math.Max(mob.attack - defense, 1);
                    }
                }

                turn++;
            }
        }

        public bool Dead() => curHealth <= 0;

        public override char Symbol => '@';
    }

    public static string Result()
    {
        // Grid
        var sb = new StringBuilder();
        if (!player.Dead())
        {
            map[player.x, player.y] = player;
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                sb.Append(map[i, j].Symbol);
            }
            sb.Append('\n');
        }
        // Passed Turns
        sb.AppendLine($"Passed Turns: {passedTurns}");
        // Player Status
        sb.AppendLine($"LV : {player.level}");
        sb.AppendLine($"HP : {Math.Max(player.curHealth, 0)}/{player.maxHealth}");
        sb.AppendLine($"ATT : {player.attack - (player.weapon?.attack ?? 0)}+{player.weapon?.attack ?? 0}");
        sb.AppendLine($"DEF : {player.defense - (player.shield?.defense ?? 0)}+{player.shield?.defense ?? 0}");
        sb.AppendLine($"EXP : {player.exp}/{player.level * 5}");

        if (bossDead)
        {
            sb.AppendLine("YOU WIN!");
        }
        else if (player.Dead() && playerKiller != null)
        {
            sb.AppendLine($"YOU HAVE BEEN KILLED BY {playerKiller.name}..");
        }
        else if (player.Dead())
        {
            sb.AppendLine("YOU HAVE BEEN KILLED BY SPIKE TRAP..");
        }
        else
        {
            sb.AppendLine("Press any key to continue.");
        }

        return sb.ToString();
    }

    static void Main(string[] args)
    {
        var tmp = Console.ReadLine()!.Split(" ").Select(int.Parse).ToArray();
        n = tmp[0];
        m = tmp[1];
        map = new Space[n, m];
        int boxCnt = 0, monsterCnt = 0, bossX = 0, bossY = 0;
        for (int i = 0; i < n; ++i)
        {
            var line = Console.ReadLine()!.Trim();
            for (int j = 0; j < m; ++j)
            {
                switch (line[j])
                {
                    case '.':
                        map[i, j] = new Blank(i, j);
                        break;
                    case '#':
                        map[i, j] = new Wall(i, j);
                        break;
                    case 'B':
                        boxCnt++;
                        break;
                    case '^':
                        map[i, j] = new Trap(i, j);
                        break;
                    case 'M':
                        bossX = i;
                        bossY = j;
                        monsterCnt++;
                        break;
                    case '&':
                        monsterCnt++;
                        break;
                    case '@':
                        player = new Player(i, j);
                        map[i, j] = new Blank(i, j);
                        break;
                    default:
                        throw new Exception("Invalid character");
                }
            }
        }

        string moves = Console.ReadLine()!.Trim();

        for (int i = 0; i < monsterCnt; ++i)
        {
            var tokens = Console.ReadLine()!.Split(" ");
            int r = int.Parse(tokens[0]) - 1, c = int.Parse(tokens[1]) - 1, w = int.Parse(tokens[3]), a = int.Parse(tokens[4]), h = int.Parse(tokens[5]), e = int.Parse(tokens[6]);
            string s = tokens[2];
            if (r == bossX && c == bossY)
            {
                map[r, c] = new Boss(r, c, s, w, a, h, e);
            }
            else
            {
                map[r, c] = new Monster(r, c, s, w, a, h, e);
            }
        }

        for (int i = 0; i < boxCnt; ++i)
        {
            var tokens = Console.ReadLine()!.Split(" ");
            int r = int.Parse(tokens[0]) - 1, c = int.Parse(tokens[1]) - 1;
            char t = tokens[2][0];
            if (t == 'W')
            {
                int at = int.Parse(tokens[3]);
                map[r, c] = new Box(r, c, new Item.Weapon(at));
            }
            else if (t == 'A')
            {
                int df = int.Parse(tokens[3]);
                map[r, c] = new Box(r, c, new Item.Shield(df));
            }
            else
            {
                Accessory ac = (Accessory)Enum.Parse<Accessory>(tokens[3]);
                map[r, c] = new Box(r, c, ac);
            }
        }


        foreach (var move in moves)
        {
            //var sb = new StringBuilder();
            //for (int i = 0; i < n; i++)
            //{
            //    for (int j = 0; j < m; j++)
            //    {
            //        if (i == player.x && j == player.y)
            //            sb.Append(player.Symbol);
            //        else
            //            sb.Append(map[i, j].Symbol);
            //    }

            //    sb.AppendLine();
            //}
            //Console.WriteLine(sb.ToString());
            //Console.WriteLine();


            // 이동
            switch (move)
            {
                case 'L':
                    player.Move(Direction.Left);
                    break;
                case 'R':
                    player.Move(Direction.Right);
                    break;
                case 'U':
                    player.Move(Direction.Up);
                    break;
                case 'D':
                    player.Move(Direction.Down);
                    break;
            }

            passedTurns++;
            // 상호작용
            var cur = map[player.x, player.y];
            // 상자와 만남
            if (cur is Box box)
            {
                if (box.item != null)
                {
                    var item = box.item;
                    if (item is Item.Weapon weapon)
                    {
                        player.weapon?.UnEquip();
                        player.weapon = weapon;
                        player.weapon.Equip();
                    }
                    else if (item is Item.Shield shield)
                    {
                        player.shield?.UnEquip();
                        player.shield = shield;
                        player.shield.Equip();
                    }
                }
                else
                {
                    player.AddAccessory(box.accessory);
                }
                map[player.x, player.y] = new Blank(player.x, player.y);
            }
            // 함정과 만남
            else if (cur is Trap trap)
            {
                trap.Trigger();
            }
            // 몬스터와 만남
            else if (cur is Monster monster)
            {
                var res = player.Fight(monster);
                // 패배
                if (!res)
                {
                    playerKiller = monster;
                }
                // 승리
                else
                {
                    if (monster is Boss)
                    {
                        bossDead = true;
                    }
                    map[player.x, player.y] = new Blank(player.x, player.y);

                    if (player.accessories.HasFlag(Accessory.HR))
                        player.curHealth = Math.Min(player.curHealth + 3, player.maxHealth);
                }
            }
            else if (cur is Blank)
            {
                // 아무것도 없음
            }
            else
            {
                throw new Exception("Invalid space");
            }

            if (player.Dead())
            {
                if (player.accessories.HasFlag(Accessory.RE))
                {
                    player.DiscardAccessory(Accessory.RE);
                    player.Resurrect();
                    continue;
                }

                break;
            }

            if (bossDead) break;
        }

        Console.WriteLine(Result());
    }
}