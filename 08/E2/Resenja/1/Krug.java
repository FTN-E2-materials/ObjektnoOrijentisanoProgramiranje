package z1;

public class Krug {
    private double r;

    public Krug(double r)
    {
        this.r = r;
    }

    public double getR()
    {
        return r;
    }

    public void setR(double r)
    {
        this.r = r;
    }

    public double getO()
    {
        return 2 * Math.PI * r;
    }

    public double getP()
    {
        return Math.pow(r, 2) * Math.PI;
    }

}
