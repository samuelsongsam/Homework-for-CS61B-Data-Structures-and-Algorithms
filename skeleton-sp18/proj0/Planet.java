public class Planet
{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Planet(Planet p){
        xxPos=p.xxPos;
        yyPos=p.yyPos;
        xxVel=p.xxVel;
        yyVel=p.yyVel;
        mass=p.mass;
        imgFileName=p.imgFileName;
    }

    public double calcDistance(Planet obj){
        double dx=this.xxPos-obj.xxPos;
        double dy=this.yyPos-obj.yyPos;
        return Math.sqrt(dx*dx+dy*dy);
    }

    public double calcForceExertedBy(Planet obj){
        return (this.mass*obj.mass*6.67*Math.pow(10,-11))/Math.pow(this.calcDistance(obj),2);
    }

    public double calcForceExertedByX(Planet obj){
        return this.calcForceExertedBy(obj)*(obj.xxPos-this.xxPos)/this.calcDistance(obj);
    }
    public double calcForceExertedByY(Planet obj){
        return this.calcForceExertedBy(obj)*(obj.yyPos-this.yyPos)/this.calcDistance(obj);
    }

    public double calcNetForceExertedByX(Planet[] planetlist){
        double res=0;
        for(Planet ele : planetlist){
            if(this.equals(ele)){
                continue;
            }
            res+=this.calcForceExertedByX(ele);
        }
        return res;
    }
    public double calcNetForceExertedByY(Planet[] planetlist){
        double res=0;
        for(Planet ele : planetlist){
            if(this.equals(ele)){
                continue;
            }
            res+=this.calcForceExertedByY(ele);
        }
        return res;
    }

    public void update(double dt,double fX,double fY){
        double a_x=fX/mass;
        double a_y=fY/mass;
        this.xxVel+=a_x*dt;
        this.yyVel+=a_y*dt;
        this.xxPos+=this.xxVel*dt;
        this.yyPos+=this.yyVel*dt;
        return;
    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
    }
}