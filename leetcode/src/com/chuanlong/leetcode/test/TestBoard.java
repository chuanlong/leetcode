package com.chuanlong.leetcode.test;

public class TestBoard {


    class Board {
        private Player player;
        private int n;

        public Board(int n) {
            this.n = n;
            this.player = new Player();
        }

        public void printBoard() {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for(int i=0; i<n; i++) {
                for(int j=0;j<n; j++) {
                    if(player.y == i && player.x == j) sb.append(player.getPlayer());
                    else sb.append("-");
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }

        public void move(String s) {
            char[] chs = s.toCharArray();
            for(int i=0; i<chs.length; i++) {
                char ch = chs[i];
                player.move(ch, n);
            }

        }
    }

    class Player {
        Direction dir;
        int y;
        int x;

        public Player() {
            this.y = 0;
            this.x = 0;
            this.dir = Direction.RIGHT;
        }
        public String getPlayer() {
            switch(dir) {
                case UP:  return "X";
                case DOWN: return "V";
                case LEFT: return "<";
                case RIGHT: return ">";
                default: return "X";
            }
        }

        public void move(char ch, int n) {
            switch(ch) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'F':
                    moveForward(n);
                    break;
                default:
                    break;
            }
        }

        private void turnLeft() {
            switch(dir) {
                case UP:  dir = Direction.LEFT; break;
                case DOWN: dir = Direction.RIGHT; break;
                case LEFT: dir = Direction.DOWN; break;
                case RIGHT: dir = Direction.UP; break;
                default: break;
            }
        }

        private void turnRight() {
            switch(dir) {
                case UP:  dir = Direction.RIGHT; break;
                case DOWN: dir = Direction.LEFT; break;
                case LEFT: dir = Direction.UP; break;
                case RIGHT: dir = Direction.DOWN; break;
                default: break;
            }
        }

        private void moveForward(int n) {
            switch(dir) {
                case UP:
                    if(y>=1) y--; break;
                case DOWN:
                    if(y<n-1) y++; break;
                case LEFT:
                    if(x>=1) x--; break;
                case RIGHT:
                    if(x<n-1) x++; break;
                default: break;
            }
        }

    }

    enum Direction {
        UP(0), DOWN(1), LEFT(2), RIGHT(3);
        int val;
        Direction(int val) {
            this.val = val;
        }
    }
}
