package baiThi;

public class Complex {
    public double realPart;
    public double imaginaryPart;

    public Complex() {
    }

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public Complex add(Complex otherNumber){
        Complex tong = new Complex();
        tong.realPart = this.realPart +otherNumber.realPart;
        tong.imaginaryPart =this.imaginaryPart +otherNumber.imaginaryPart;
        return tong;
    }

    public Complex subtract(Complex otherNumber){
        Complex hieu = new Complex();
        hieu.realPart = this.realPart -otherNumber.realPart;
        hieu.imaginaryPart =this.imaginaryPart -otherNumber.imaginaryPart;
        return hieu;
    }


    public Complex multiply(Complex otherNumber){
        Complex nhan = new Complex();
        nhan.realPart = this.realPart*otherNumber.realPart - otherNumber.imaginaryPart*this.imaginaryPart;
        nhan.imaginaryPart =this.realPart*otherNumber.imaginaryPart +this.imaginaryPart*otherNumber.realPart;
        return nhan;
    }


    public Complex divide(Complex otherNumber){
        Complex chia = new Complex();
        chia.realPart = (otherNumber.realPart*this.realPart + otherNumber.imaginaryPart*this.imaginaryPart)/(Math.pow(otherNumber.realPart,2)+Math.pow(otherNumber.imaginaryPart,2));
        chia.imaginaryPart =(otherNumber.realPart*this.imaginaryPart -otherNumber.imaginaryPart*this.realPart)/(Math.pow(otherNumber.realPart,2)+Math.pow(otherNumber.imaginaryPart,2));
        return chia;
    }


    @Override
    public String toString() {
        return "Complex = " + realPart + "+" + imaginaryPart + "*i";
    }
}