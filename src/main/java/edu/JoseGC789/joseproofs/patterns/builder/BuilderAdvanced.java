package edu.JoseGC789.joseproofs.patterns.builder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.function.Consumer;

/**
 * Example immutable data-class...
 * In a real project this class's scope should be set to public and be in its own separate file.
 */
@Getter
@ToString
@EqualsAndHashCode
final class MyDataLambda{
    private final Long id; //Mandatory and auto generated
    private final float amount; //Mandatory
    private final String reason;
    private final LocalDateTime date;

    /**
     * Force data-classes to be non-instantiable and immutable.
     * @param id
     * @param amount
     * @param reason
     * @param date
     */
    private MyDataLambda(final Long id, final float amount, final String reason, final LocalDateTime date){
        this.id = id;
        this.amount = amount;
        this.reason = reason;
        this.date = date;
    }

    /**
     * Functional programming's approach at a builder
     * May confuse the heck out of you if you don't anything about functional programming, lambdas expressions and method references
     * If you don't need a constructor, you can turn it into an inner class.
     */
    public static final class Builder{
        private final Long id;
        public float amount;
        public String reason = "Empty";
        public LocalDateTime date = LocalDateTime.now();

        public Builder(final Long id, final float amount){
            this.id = id;
            this.amount = amount;
        }

        public Builder with (final Consumer<Builder> builderConsumer){
            builderConsumer.accept(this);
            return this;
        }

        public MyDataLambda build(){
            return new MyDataLambda(id,amount,reason,date);
        }
    }
}

/**
 * Demonstration
 */
public class BuilderAdvanced {
    public static void main(String[] args){
        final MyDataLambda myDataLambda = new MyDataLambda
                .Builder(5L,345f)
                .with(BuilderAdvanced::createData)
                .build();
        System.out.println("myDataLambda = " + myDataLambda);
    }

    /**
     * Construction extracted to a private static method so we can take advantage of method's references
     * @param with
     */
    private static void createData(final MyDataLambda.Builder with){
        with.reason = "Alquiler";
        with.date = LocalDateTime.of(1994, Month.of(5),5,15,50);
    }
}
