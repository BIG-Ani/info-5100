package Ass5Cat;

import Ass5.Pet;
import Ass5.SexEnum;
import Ass5Board.Boardable;

public class Cat extends Pet implements Boardable {

    private String hairLength;
    private int boardStartMonth;
    private int boardStartDay;
    private int boardStartYear;
    private int boardEndMonth;
    private int boardEndDay;
    private int boardEndYear;

    public Cat() {
    }

    public Cat(String ownerName, String petName, String color, String hairLength) {
        super(ownerName, petName, color);
        this.hairLength = hairLength;
    }

    public String getHairLength() {
        return hairLength;
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        if (month >= 1 && month <= 12)
            this.boardStartMonth = month;
        else{
            System.out.println("Input month is error");
            return;
        }

        if (day >= 1 && day <= 31)
            this.boardStartDay = day;
        else{
            System.out.println("Input date day is error");
            return;
        }

        if (year >= 1000 && year <= 9999)
            this.boardStartYear = year;
        else{
            System.out.println("Input year is error");
            return;
        }
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        if (month >= 1 && month <= 12)
            this.boardEndMonth = month;
        else{
            System.out.println("Input month is error");
            return;
        }

        if (day >= 1 && day <= 31)
            this.boardEndDay = day;
        else{
            System.out.println("Input date day is error");
            return;
        }

        if (year >= 1000 && year <= 9999)
            this.boardEndYear = year;
        else{
            System.out.println("Input year is error");
            return;
        }
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        if (year < boardStartYear)
            return false;

        if(year > boardEndYear)
            return false;

        long totalBoardingTime = getTotalTimeAfterStart(month, day, year);
        long totalBoardEndTime = getTotalTimeAfterStart(boardEndMonth, boardEndDay, boardEndYear);

        if(totalBoardingTime >= totalBoardEndTime && totalBoardingTime <= totalBoardEndTime)
            return true;
        else
            return false;
    }

    private long getTotalTimeAfterStart(int month, int day, int year) {
        long timeInDay = 0;

        timeInDay += year * 365;

        for(int i = 1; i <= month; i++){

            switch (i){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    timeInDay += 31;
                    break;
                case 2:
                    timeInDay += 28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    timeInDay += 30;
                    break;
            }
        }

        timeInDay += day;

        return timeInDay;
    }


    @Override
    public String toString() {
        String str1 = this.getClass().getName() + ": \n";
        String str2 = super.toString() + "\n\n";

        return "\n" + str1 + str2 + "Hair: " + getHairLength();
    }

//    //@Test
//    public static void main(String[] args) {
//        Cat cat = new Cat("Bob", "Tom", "Black", "Short");
//        cat.setSex(SexEnum.SPAYED.sexId);
//
//        System.out.println(cat);
//    }
}
