public class NBody{
    private static int N;
    private static double R;

    public static double readRadius(String FileName){
        In in = new In(FileName);
        N=in.readInt();
        R=in.readDouble();
        return R;
    }

    public static Planet[] readPlanets(String FileName){
        readRadius(FileName);
        In txt=new In(FileName);
        txt.readInt();
        txt.readDouble();
        Planet[] res=new Planet[N];
        for(int i=0;i<N;i+=1){
            res[i]=new Planet(txt.readDouble(), txt.readDouble(), txt.readDouble(), txt.readDouble(), txt.readDouble(), txt.readString());
        }
        return res;
    }

    private static String imageToDraw = "images/starfield.jpg";


    public static void main(String[] args){
        /**Collecting All Needed Input*/
        double T = Double.parseDouble(args[0]);
        double dt= Double.parseDouble(args[1]);
        String filename = args[2];
        StdDraw.enableDoubleBuffering();
        Planet[] Planets = readPlanets(filename);
        StdDraw.setScale(-R,R);
        StdDraw.clear();

        StdDraw.picture(0,0,imageToDraw);
        for(Planet pl:Planets){
            pl.draw();
        }
        StdDraw.show();
        double Time=0;
        while(Time<=T){
            StdDraw.clear();
            double[] xForces = new double[N];
            double[] yForces = new double[N];
            for(int i=0;i<N;i++){
                xForces[i]=Planets[i].calcNetForceExertedByX(Planets);
                yForces[i]=Planets[i].calcNetForceExertedByY(Planets);
            }
            for(int i=0;i<N;i++){
                Planets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0,0,imageToDraw);
            for(Planet pl:Planets){
                pl.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            Time+=dt;
        }

        StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", R);
        for (int i = 0; i < Planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                    Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
        }
    }
}
