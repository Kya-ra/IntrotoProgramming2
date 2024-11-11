import java.util.Scanner;

import  java.lang.Math;

public class Rational
{
    int top = 0;
    int bottom = 0;
    Rational(int numerator, int denominator) {
        top = numerator;
        bottom = denominator;
    }

    public Rational add(Rational r2)
    {
        int newTop = this.top*r2.bottom + r2.top*this.bottom;
        int newBottom = this.bottom*r2.bottom;
        return new Rational(newTop, newBottom).simplify();
    }

    public int getNumerator()
    {
        return this.top;
    }

    public int getDenominator()
    {
        return this.bottom;
    }

    public Rational sub(Rational r2)
    {
        int newTop = this.top*r2.bottom - r2.top*this.bottom;
        int newBottom = this.bottom*r2.bottom;
        return new Rational(newTop, newBottom).simplify();
    }

    public Rational mul(Rational r2)
    {
        int newTop = this.top * r2.top;
        int newBottom = this.bottom * r2.bottom;
        return new Rational(newTop, newBottom).simplify();
    }

    public Rational div(Rational r2)
    {
        int newTop = this.top*r2.bottom;
        int newBottom = this.bottom*r2.top;
        return new Rational(newTop, newBottom).simplify();
    }

    public boolean equals(Rational r2)
    {
        return ((float) this.top / (float) this.bottom == (float) r2.top / (float) r2.bottom);
    }

    public boolean isLessThan(Rational r2)
    {
        return (float) this.top / (float) this.bottom < (float) r2.top / (float) r2.bottom;
    }

    public Rational simplify() {
        //if (this.top % this.bottom == 0) {
            //return new Rational(this.top / this.bottom, 1);
        //} else {
            int HCF = 1;
            for (int i = 2; i <= Math.min(Math.abs(this.top), Math.abs(this.bottom)); i++) {
                if (this.top % i == 0 && this.bottom % i == 0) {
                    HCF = i;
                }
            }

            return new Rational(this.top / HCF, this.bottom / HCF);
        //}
    }

    public String toString()
    {
        if (this.top == 0 || this.bottom == 1) {
            return String.valueOf(this.top);
        }
        else {
            return this.top + "/" + this.bottom;
        }

        }


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter two rational numbers separated by a space e.g. \"5/7 9/6\"");
        String fraction1 = input.next();
        String fraction2 = input.next();
        String[] fraction1parts = fraction1.split("/");
        String[] fraction2parts = fraction2.split("/");
        Rational r1 = new Rational(Integer.parseInt(fraction1parts[0]), Integer.parseInt(fraction1parts[1]));
        Rational r2 = new Rational(Integer.parseInt(fraction2parts[0]), Integer.parseInt(fraction2parts[1]));

        System.out.println();
        System.out.println(fraction1 + " " + fraction2);
        System.out.println();
        System.out.println(r1.toString() + " + " + r2.toString() + " = " + r1.add(r2).toString());
        System.out.println(r1.toString() + " - " + r2.toString() + " = " + r1.sub(r2).toString());
        System.out.println(r1.toString() + " * " + r2.toString() + " = " + r1.mul(r2).toString());
        System.out.println(r1.toString() + " / " + r2.toString() + " = " + r1.div(r2).toString());
        System.out.println("( "+ r1.toString() + " == " + r2.toString() + " ) = " + r1.equals(r2));
        System.out.println("( "+ r1.toString() + " < " + r2.toString() + " ) = " + r1.isLessThan(r2));
        System.out.println(r1.toString() + " simplified is " + r1.simplify().toString());
        System.out.println(r2.toString() + " simplified is " + r2.simplify().toString());
    }
}
