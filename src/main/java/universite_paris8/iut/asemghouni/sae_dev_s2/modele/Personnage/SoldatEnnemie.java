package universite_paris8.iut.asemghouni.sae_dev_s2.modele.Personnage;

import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Arme.Arme;
import universite_paris8.iut.asemghouni.sae_dev_s2.modele.Environnement.Environnement;

public class SoldatEnnemie extends Personnage {

    private Personnage cible;
    private SoldatEnnemie soldatEnnemie;

    public SoldatEnnemie(String nom, int PointVie, int PointAttaque, int PointDefense, Arme arme, Environnement envi, Personnage cible) {
        super(nom, 60, 30, 30, arme, envi);
        this.cible = cible;
    }

    public void suivreJoueur2() {

        double joueurX = cible.getX();
        double joueurY = cible.getY();
        double ennemiX = this.getX();
        double ennemiY = this.getY();

        double deltaX = joueurX - ennemiX;
        double deltaY = joueurY - ennemiY;

        double longueur = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        double vitesse = 8;

        if (longueur != 0) {
            deltaX = (deltaX / longueur) * vitesse;
            deltaY = (deltaY / longueur) * vitesse;
        }

        if (!cible.detectCollision((int) ennemiX, (int) ennemiY)) {
            this.setX((int) (ennemiX + deltaX));
            this.setY((int) (ennemiY + deltaY));
        }
    }

//    public void suivreJoueur() {
//
//        double joueurX = cible.getX();
//        double joueurY = cible.getY();
//        double ennemiX = this.getX();
//        double ennemiY = this.getY();
//
//        double deltaX = joueurX - ennemiX;
//        double deltaY = joueurY - ennemiY;
//
//        double vitesse = 5;
//
//        if (Math.abs(deltaX) > Math.abs(deltaY)) {
//
//            if (deltaX > 0) {
//                this.setX((int) (ennemiX + vitesse));
//            } else {
//                this.setX((int) (ennemiX - vitesse));
//            }
//
//        } else {
//
//            if (deltaY > 0) {
//                this.setY((int) (ennemiY + vitesse));
//            } else {
//                this.setY((int) (ennemiY - vitesse));
//            }
//
//        }
//
//    }


//    package model.PathFinder;
//
//import java.util.ArrayList;
//import java.util.Random;
//import model.PathFinder.resources.CellBfs;
//import model.gameMap.GameMap;
//import model.gameMap.additional.MapReader;
//
//
//        private static boolean random;
//        private final static Random ran = new Random();
//        private final static boolean[] seenMap = new boolean[MapReader.MAPLENGTH*MapReader.MAPLENGTH];
//        private static GameMap map;
//
//
//        /**
//         *
//         * @param map
//         * @param cellStart
//         * @param cellEnd un tableau des cellules on lon peu arriver
//         * @param joinTheCell si vrai le personnage ne bougeras que si il peu acceder a une des cellules d'arrivé
//         * @param nbCycle 0 si autant de mouvement que possible
//         * @return
//         */
//        public final static int simpleMove(GameMap map, int cellStart, int[] cellEnd, boolean joinTheCell, int nbCycle) {
//
//            for (int i : cellEnd) {
//                if(i == cellStart)
//                    return cellStart;
//            }
//            for(int i = 0 ; i<seenMap.length; i++)
//                seenMap[i]=false;
//            random=ran.nextBoolean();
//            ArrayList<CellBfs> all=new ArrayList<CellBfs>();
//            ArrayList<CellBfs> last=new ArrayList<CellBfs>();
//            last.add(new CellBfs(null, cellStart));
//            CellBfs find = null;
//            do{
//                ArrayList<CellBfs> empty=new ArrayList<CellBfs>();
//                find= checkAroud(last, empty, seenMap, map, cellEnd ,joinTheCell);
//                all.addAll(empty);
//                last=empty;
//                nbCycle--;
//                if (last.isEmpty())
//                    break;
//            }while (find==null && !last.isEmpty() && nbCycle != 0);
//            if (find==null) {
//                return cellStart;
//            }
//            if (find.getLast()==null)
//                return find.getIdCell();
//            while(find.getLast().getLast()!=null){
//                find=find.getLast();
//            }
//
//            return find.getIdCell();
//
//        }
//
//        public final static int simpleMove(GameMap map, int cellStart, int[] cellEnd, boolean joinTheCell) {
//            return simpleMove(map, cellStart, cellEnd, joinTheCell, -1);
//        }
//
//        public final static int simpleMove(GameMap map, int cellStart, int cellEnd, boolean joinTheCell) {
//            int[] tab ={cellEnd};
//            return simpleMove(map, cellStart, tab, joinTheCell, -1);
//        }
//
//        /*
//         * regarde autour d'une case
//         */
//        private static CellBfs checkAroud(ArrayList<CellBfs> last, ArrayList<CellBfs> empty, boolean[] seenMap, GameMap map,int[] cellEnd, boolean joinTheCell) {
//            for (CellBfs sommet: last) {
//                CellBfs check=null;
//                for (int i = 0; i<2 ;i++) {
//                    if(random) {
//                        check=checkSingleCell(empty, sommet, map, cellEnd,joinTheCell, +1);
//                        if (check!=null)
//                            return check;
//                        check=checkSingleCell(empty, sommet, map, cellEnd,joinTheCell, -1);
//                    }
//                    if(!random) {
//                        check=checkSingleCell(empty, sommet, map, cellEnd,joinTheCell, +MapReader.MAPLENGTH);
//                        if (check!=null)
//                            return check;
//                        check=checkSingleCell(empty, sommet, map, cellEnd,joinTheCell, -MapReader.MAPLENGTH);
//                    }
//                    random=!random;
//
//                    if (check!=null)
//                        return check;
//                }
//
//            }
//
//            return null;
//
//        }
//
//        private static CellBfs checkSingleCell( ArrayList<CellBfs> empty,CellBfs sommet, GameMap map, int[] cellEnd,boolean joinTheCell, int increment) {
//            if(!joinTheCell) {
//                for (int i2 : cellEnd) {
//                    if (sommet.getIdCell()+increment==i2) {
//                        CellBfs check= checkCase(sommet, map, sommet.getIdCell()+ increment);
//                        if (check!=null) {
//                            return check;
//                        }
//                        return sommet;
//                    }
//                }
//            }
//
//            CellBfs check= checkCase(sommet, map, sommet.getIdCell()+ increment);
//            if (check!=null) {
//                empty.add(check);
//                if (joinTheCell) {
//                    for (int i2 : cellEnd) {
//                        if (sommet.getIdCell()+increment==i2)
//                            return check;
//                    }
//                }
//            }
//            return null;
//        }
//
//        private final static CellBfs checkCase(CellBfs lastCase, GameMap map, int id) {
//            if (id>=0 && id<MapReader.MAPLENGTH*MapReader.MAPLENGTH )
//                if(!seenMap[id]) {
//                    seenMap[id]=true;
//                    if (map.isWalkableAt(id)){
//                        return new CellBfs(lastCase, id);
//                    }
//                }
//            return null;
//        }
//
//    }

}
