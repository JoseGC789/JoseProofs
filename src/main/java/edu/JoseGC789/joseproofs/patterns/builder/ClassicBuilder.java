package edu.JoseGC789.joseproofs.patterns.builder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * Example immutable data-class...
 * In a real project this class's scope should be set to public and be in its own separate file.
 */
@Getter
@ToString
@EqualsAndHashCode
final class MyDataClassic{
    private final Long id; //Mandatory and auto generated
    private final float amount; //Mandatory
    private final String reason;
    private final LocalDateTime date;

    /**
     * Force data-classes to be non-instantiable and immutable.
     *
     * @param id
     * @param amount
     * @param reason
     * @param date
     */
    private MyDataClassic(final Long id, final float amount, final String reason, final LocalDateTime date){
        this.id = id;
        this.amount = amount;
        this.reason = reason;
        this.date = date;
    }

    /**
     * Classic builder implementation for this data-class...
     * If you don't need a constructor, you can turn it into an inner class.
     */
    public static final class Builder{
        private final Long id;
        private float amount;
        private String reason = "Empty";
        private LocalDateTime date = LocalDateTime.now();

        public Builder(final Long id, final float amount){
            this.id = id;
            this.amount = amount;
        }

        public Builder withAmount(final float amount){
            this.amount = amount;
            return this;
        }

        public Builder withReason(final String reason){
            this.reason = reason;
            return this;
        }

        public Builder withDate(final LocalDateTime date){
            this.date = date;
            return this;
        }

        public MyDataClassic build(){
            return new MyDataClassic(id, amount, reason, date);
        }
    }
}

/**
 * Demonstration
 */
public final class ClassicBuilder{
    public static void main(String[] args){
        final MyDataClassic myDataClassic = new MyDataClassic
                .Builder(5L, 123f)
                .withReason("Alquiler")
                .withDate(LocalDateTime.of(1994, Month.of(5), 5, 15, 50))
                .build();
        System.out.println("myDataClassic = " + myDataClassic);
    }
}