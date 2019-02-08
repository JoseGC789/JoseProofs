package edu.JoseGC789.joseproofs.patterns;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
final class MyDataClassic{
    private final Long id; //Mandatory and auto generated
    private final float amount; //Mandatory
    private final String reason;
    private final LocalDateTime date;

    private MyDataClassic(final Long id, final float amount, final String reason, final LocalDateTime date){
        this.id = id;
        this.amount = amount;
        this.reason = reason;
        this.date = date;
    }

    public static final class Builder{
        private final Long id;
        private float amount;
        private String reason = "Empty";
        private LocalDateTime date = LocalDateTime.now();

        public Builder(final Long id,final float amount){
            this.id = id;
            this.amount = amount;
        }

        public Builder amount(final float amount){
            this.amount = amount;
            return this;
        }

        public Builder reason(final String reason){
            this.reason = reason;
            return this;
        }

        public Builder date(final LocalDateTime date){
            this.date = date;
            return this;
        }

        public MyDataClassic build(){
            return new MyDataClassic(id,amount,reason,date);
        }
    }
}

public class BuilderClassic{
    public static void main(String[] args){
        final MyDataClassic myDataClassic = new MyDataClassic.Builder(5L,123f).reason("Alquiler").build();
        System.out.println("myDataClassic = " + myDataClassic);
    }
}