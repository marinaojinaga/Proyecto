package logicaDeDatos;

import java.util.ArrayList;

public class MergeSort <t extends IComparableProyecto>{

    public ArrayList<t> mergeSortAlfabetico(ArrayList<t> merges){
        ArrayList<t> l = new ArrayList<t>();
        ArrayList<t> r = new ArrayList<t>();
        if(merges.size()==1){
            return merges;
        }else{
            for(int i=0;i<merges.size();i++){
                if(i<(merges.size()/2)){
                    l.add(merges.get(i));
                }else {
                    r.add(merges.get(i));
                }
            }
            l = mergeSortAlfabetico(l);
            r = mergeSortAlfabetico(r);
        }
        return mergeAlfabetico(l,r);
    }

    public ArrayList<t> mergeAlfabetico(ArrayList<t> l,ArrayList<t> r){
        ArrayList<t> mezclar = new ArrayList<t>();
        while (l.size()>0 && r.size()>0){
            if(l.get(0).compararAlfabetico(r.get(0))){
                mezclar.add(r.get(0));
                r.remove(0);
            }else {
                mezclar.add(l.get(0));
                l.remove(0);
            }
        }
        while (l.size()>0 && r.size()==0){
            mezclar.add(l.get(0));
            l.remove(0);
        }while (r.size()>0 && l.size()==0){
            mezclar.add(r.get(0));
            r.remove(0);
        }
        return mezclar;
    }

    public ArrayList<t> mergeSortBoolean(ArrayList<t> merges){
        ArrayList<t> l = new ArrayList<t>();
        ArrayList<t> r = new ArrayList<t>();
        if(merges.size()==1){
            return merges;
        }else{
            for(int i=0;i<merges.size();i++){
                if(i<(merges.size()/2)){
                    l.add(merges.get(i));
                }else {
                    r.add(merges.get(i));
                }
            }
            l = mergeSortBoolean(l);
            r = mergeSortBoolean(r);
        }
        return mergeBoolean(l,r);
    }

    public ArrayList<t> mergeBoolean(ArrayList<t> l,ArrayList<t> r){
        ArrayList<t> mezclar = new ArrayList<t>();
        while (l.size()>0 && r.size()>0){
            if(l.get(0).compararBool(r.get(0))){
                mezclar.add(r.get(0));
                r.remove(0);
            }else {
                mezclar.add(l.get(0));
                l.remove(0);
            }
        }
        while (l.size()>0 && r.size()==0){
            mezclar.add(l.get(0));
            l.remove(0);
        }while (r.size()>0 && l.size()==0){
            mezclar.add(r.get(0));
            r.remove(0);
        }
        return mezclar;
    }

}
