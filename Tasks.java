package Tasks;


public class Tasks {

    private String title;

    private int day;
    private int month;
    private int year;
    private String status;
    private String description;




    public String getTitle() {
        return title;
    }


    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }


    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDay(int day){
        if (day > 0 && day < 32){

            this.day = day;

        }
        else {

            System.out.println("Invalid Input for the Day");

        }
    }

    public void setMonth(int month){

        if (month > 0 && month < 13){
            this.month = month;
        }
        else {

            System.out.println("Invalid Input for the Month");

        }
    }

    public void setYear(int year){
        if (year > 2022 && year < 3000){

            this.year = year;

        }
        else{

            System.out.println("Invalid Input for the Year");
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
