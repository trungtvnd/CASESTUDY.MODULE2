package model;

public class OfficeLevel {
    private String office;

    public OfficeLevel() {
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(int chooseOffice) {
        if (chooseOffice == 1) {
            this.office = "Director";
        } else if (chooseOffice == 2) {
            this.office = "Manager";
        } else if (chooseOffice == 3) {
            this.office = "Professional";
        } else if (chooseOffice == 4) {
            this.office = "Senior";
        } else if (chooseOffice == 5) {
            this.office = "Junior";
        } else if (chooseOffice == 6) {
            this.office = "Fresher";
        } else if (chooseOffice == 7) {
            this.office = "Intern";
        }
    }
}