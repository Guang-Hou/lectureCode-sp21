
public class PieceGrid {

    private static class Piece {
        private int x, y;

        Piece(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static Piece[] createPieceArr(int... args) {
        Piece[] pieceArr = new Piece[args.length / 2];

        for (int i = 0; i < args.length - 1; i += 2) {
            pieceArr[i / 2] = new Piece(args[i], args[i + 1]);
        }
        return pieceArr;
    }

//    public static Piece[][] groupByLat(Piece[] p) {
//        int dim = (int) Math.sqrt(p.length);
//        Piece[][] grouped = new Piece[dim][dim];
//        int highestIndex = -1;
//        boolean inserted = false;
//        for (Piece pi : p) {
//            for (int i = 0; i <= highestIndex; i += 1) {
//                if (grouped[i][0].y == pi.y) {
//                    for (int j = 0; j < grouped[i].length; j += 1) {
//                        if (grouped[i][j] == null) {
//                            grouped[i][j] = pi;
//                            inserted = true;
//                            break;
//                        }
//                    }
//                }
//            }
//            if (!inserted) {
//                grouped[highestIndex + 1][0] = pi;
//                highestIndex += 1;
//            }
//        }
//        return grouped;
//    }

    public static Piece[][] groupByLat(Piece[] p) {
        int dim = (int) Math.sqrt(p.length);
        Piece[][] grouped = new Piece[dim][dim];
        for (Piece pi : p) {
            for (int i = 0; i < grouped.length; i += 1) {
                if (grouped[i][0] == null) {
                    grouped[i][0] = pi;
                    break;
                } else if (grouped[i][0].y == pi.y) {
                    for (int j = 0; j < grouped[i].length; j += 1) {
                        if (grouped[i][j] == null) {
                            grouped[i][j] = pi;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return grouped;
    }

    public static void sortByLat(Piece[][] p) {
        for (int i = 0; i < p.length; i += 1) {
            int largestLatIndex = getLargestLatIndex(p, i);
            Piece[] temp = p[i];
            p[i] = p[largestLatIndex];
            p[largestLatIndex] = temp;
        }
    }

    public static int getLargestLatIndex(Piece[][] p, int start) {
        int largestLat = p[start][0].y, largestLatIndex = start;
        for (int i = start + 1; i < p.length; i += 1) {
            if (p[i][0].y > largestLat) {
                largestLat = p[i][0].y;
                largestLatIndex = i;
            }
        }
        return largestLatIndex;
    }

    public static void sortByLong(Piece[][] p) {
        for (Piece[] pi : p) {
            for (int i = 0; i < p.length; i += 1) {
                int smallestLongIndex = getSmallestLongIndex(pi, i);
                Piece temp = pi[i];
                pi[i] = pi[smallestLongIndex];
                pi[smallestLongIndex] = temp;
            }
        }
    }

    public static int getSmallestLongIndex(Piece[] p, int start) {
        int smallestLong = p[start].x, smallestLongIndex = start;
        for (int i = start + 1; i < p.length; i += 1) {
            if (p[i].x < smallestLong) {
                smallestLong = p[i].x;
                smallestLongIndex = i;
            }
        }
        return smallestLongIndex;
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 10, 10, 20, 0, 0, 0, 20, 20, 20, 10, 10, 0, 0, 20, 0, 10};
        Piece[] pieceArr = createPieceArr(data);
        Piece[][] pieceGrid = groupByLat(pieceArr);
        sortByLat(pieceGrid);
        sortByLong(pieceGrid);

        int dimension = pieceGrid.length;
        for (int i = 0; i < dimension; i += 1) {
            for (int j = 0; j < dimension; j += 1) {
                System.out.print(pieceGrid[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

