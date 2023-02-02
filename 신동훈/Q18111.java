import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Q18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int length = Integer.parseInt(input[0]);

        long blockCount = Long.parseLong(input[2]);

        List<List<Integer>> map = new ArrayList<>();
        for (int y = 0; y < length; y++) {
            map.add(stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
            );
        }
        Ground ground = new Ground(map);
        Player player = new Player(new Inventory(blockCount));
        Game game = new Game(ground, player);
        Game.ResultDto resultDto = game.trimmingGround();

        System.out.println(resultDto.time() + " " + resultDto.height());
    }

    static class TrimException extends RuntimeException {
    }

    static class Game {
        private final Ground ground;
        private final Player player;

        public Game(final Ground ground, final Player player) {
            this.ground = ground;
            this.player = player;
        }

        /**
         * 땅 다듬기
         */
        public ResultDto trimmingGround() {
            int time = Integer.MAX_VALUE;
            int height = 0;
            for (int candidateHeight = 0; candidateHeight <= 256; candidateHeight++) {
                Player tempPlayer = new Player(player);
                try {
                    int resultTime = trim(candidateHeight, tempPlayer, ground);
                    if (time > resultTime) {
                        time = resultTime;
                        height = candidateHeight;
                    } else if (time == resultTime) {
                        height = Math.max(candidateHeight, height);
                    }
                } catch (TrimException e) {
                    break;
                }
            }
            return new ResultDto(time, height);
        }

        static class ResultDto {
            private final int time;
            private final int height;

            public ResultDto(int time, int height) {
                this.time = time;
                this.height = height;
            }

            public int time() {
                return time;
            }

            public int height() {
                return height;
            }
        }

        private int trim(int height, Player player, Ground ground) {
            int time = 0;
            int requiredBlock = 0;
            for (int y = 0; y < ground.length(); y++) {
                for (int x = 0; x < ground.width(); x++) {
                    int groundHeight = ground.getHeight(x, y);

                    if (groundHeight > height) {
                        player.digUp(groundHeight - height);
                        time += 2 * (groundHeight - height);
                    } else if (groundHeight < height) {
                        requiredBlock += (height - groundHeight);
                        time += (height - groundHeight);
                    }
                }
            }
            player.fill(requiredBlock);
            return time;
        }
    }

    static class Ground {
        private final List<List<Integer>> map;

        public Ground(final List<List<Integer>> map) {
            this.map = map;
        }

        public int width() {
            return map.get(0).size();
        }

        public int length() {
            return map.size();
        }

        public int getHeight(int x, int y) {
            return map.get(y).get(x);
        }
    }

    static class Player {
        private final Inventory inventory;

        public Player(final Inventory inventory) {
            this.inventory = inventory;
        }

        public Player(final Player player) {
            this.inventory = new Inventory(player.inventory);
        }

        public void digUp(int blockCount) {
            this.inventory.add(blockCount);
        }

        public void fill(int blockCount) {
            this.inventory.remove(blockCount);
        }
    }

    static class Inventory {
        private long blockCount;

        public Inventory(final long blockCount) {
            this.blockCount = blockCount;
        }

        public Inventory(final Inventory inventory) {
            this.blockCount = inventory.blockCount;
        }

        public void remove(final long blockCount) {
            if (this.blockCount < blockCount) {
                throw new TrimException();
            }
            this.blockCount -= blockCount;
        }

        public void add(final long blockCount) {
            this.blockCount += blockCount;
        }
    }
}
