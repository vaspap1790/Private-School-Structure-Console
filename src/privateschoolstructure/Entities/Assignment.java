package privateschoolstructure.Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import privateschoolstructure.Random;

public class Assignment {

    private  String title;
    private String description;
    private Date subDateTime;
    private String oralMark;
    private String totalMark;
    private int term;

    
    public Assignment() {
    }
    
    public Assignment(Assignment a){
        this.title = a.title;
        if(a.getTerm()==1){
            this.subDateTime = Random.randomDeadline1term();
        }
        else {
            this.subDateTime = Random.randomDeadline2term();
        }
        this.oralMark = Random.randomMark();
        this.totalMark = Random.randomMark();
        this.description = a.description;
        this.term = a.term;
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }
    
    
    public Date getSubDateTime() {
        return subDateTime;
    }

    public String getOralMark() {
        return oralMark;
    }

    public void setOralMark(String oralMark) {
        this.oralMark = oralMark;
    }

    public String getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(String totalMark) {
        this.totalMark = totalMark;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setSubDateTime(Date subDateTime) {
        this.subDateTime = subDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

    @Override
    public String toString() {
        return "Assignment{" + "title=" + title + ", description=" + description + '}';
    }

}
