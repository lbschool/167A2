/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * base crime book constructor, extends book constructor
 */
public class Crime extends Book{
    private int daysOverdue;
    private int penalty;
    
    public Crime()
    {
        super("def", 0, 0, "def", 0, "00/00/00", "def");
        daysOverdue = 0;
        penalty = 0;
    }
    
    public Crime(String t, int i, double s, String a, int p, String d, String n, int x, int y)
    {
        super(t, i, s, a, p, d, n);
        daysOverdue = x;
        penalty = y;
    }

    public int getDaysOverdue() {
        return daysOverdue;
    }

    public void setDaysOverdue(int daysOverdue) {
        this.daysOverdue = daysOverdue;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
}
