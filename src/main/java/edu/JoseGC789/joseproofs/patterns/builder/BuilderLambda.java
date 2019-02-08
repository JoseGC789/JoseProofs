package edu.JoseGC789.joseproofs.patterns;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.function.Consumer;

@Getter
@ToString
@EqualsAndHashCode
final class MyDataLambda{
    private final Long id; //Mandatory and auto generated
    private final float amount; //Mandatory
    private final String reason;
    private final LocalDateTime date;

    private MyDataLambda(final Long id, final float amount, final String reason, final LocalDateTime date){
        this.id = id;
        this.amount = amount;
        this.reason = reason;
        this.date = date;
    }

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

public class BuilderLambda{
    public static void main(String[] args){
        final MyDataLambda myDataLambda = new MyDataLambda
                .Builder(5L,345f)
                .with(
                        BuilderLambda::accept)
                .build();
        System.out.println("myDataLambda = " + myDataLambda);
    }

    private static void accept(final MyDataLambda.Builder $){
        $.reason = "Alquiler";
        $.date = LocalDateTime.now();
    }
}
