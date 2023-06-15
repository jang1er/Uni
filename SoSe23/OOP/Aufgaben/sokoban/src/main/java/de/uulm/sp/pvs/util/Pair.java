package de.uulm.sp.pvs.util;

public final class Pair<F extends Comparable<F> ,S extends Comparable<S>> implements Comparable<Pair<F,S>>{

    private final F first;
    private final S second;

    public Pair(F first, S second){
        this.first = first;
        this.second = second;
    }

    public final F getFirst() {
        return first;
    }

    public final S getSecond() {
        return second;
    }

    @Override
    public String toString(){
        return first.toString() + " / " + second.toString();
    }

    @Override
    public int hashCode(){
        return first.hashCode() + second.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(obj.getClass() != this.getClass())return false;

        Pair<?, ?> other = (Pair<?, ?>) obj;
        if(first == null){
            if(other.first != null)return false;
        }else if (!first.equals(other.first))return false;
        if(second == null){
            if(other.second != null)return false;
        }else if(!second.equals(other.second))return false;
        return true;
    }

    @Override
    public int compareTo(Pair<F, S> fsPair) {
        int compareFirst = first.compareTo(fsPair.getFirst());
        int compareSecond = second.compareTo(fsPair.getSecond());

        return (compareFirst != 0) ? compareFirst : compareSecond;
    }
}