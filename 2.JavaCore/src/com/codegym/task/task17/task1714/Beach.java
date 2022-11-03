package com.codegym.task.task17.task1714;

/* 
Comparable

*/

public class Beach implements Comparable<Beach> {

    private String name;
    private float distance;
    private int quality;

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public synchronized static void main(String[] args) {
        Beach beach1 = new Beach("Venice", 32, 7);
        Beach beach2 = new Beach("Santa Monica", 43, 5);
        System.out.println(beach1.compareTo(beach2));

    }

    @Override
    public synchronized int compareTo(Beach o) {
        int quality1 = this.getQuality();
        int quality2 = o.getQuality();
        int ranking;
        if (this == o) {
            return 0;
        }
        ranking = quality1 > quality2 ? quality1 - quality2 : quality2 - quality1;
        ranking += this.distance > o.distance ? o.distance - this.distance : this.distance - o.distance;
        return ranking;
        }
}
        
        //CodeGyms Solutions
//        @Override
//        public synchronized int compareTo(com.codegym.task.task17.task1714.Beach obj) {
//            int distanceParam = (int) (distance - obj.getDistance());
//            int qualityParam = quality - obj.getQuality();
//            return 10000 * name.compareTo(obj.getName()) + 100 * distanceParam + qualityParam;
//        }
    
