package com.example.lab4;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@PageTitle("Calculator")
@Route(value = "index1")
public class MathView extends VerticalLayout {

    private TextField n1;
    private TextField n2;
    private TextField ans;
    private Label text;
    private Button sum;
    private Button minus;
    private Button mul;
    private Button div;
    private Button mod;
    private Button max;


    public MathView() {
        n1 = new TextField("Number 1");
        n1.getStyle().set("width", "30em");
        n2 = new TextField("Number 2");
        n2.getStyle().set("width", "30em");
        text = new Label("Operator");
        sum = new Button("+");
        minus = new Button("-");
        mul = new Button("x");
        div = new Button("/");
        mod = new Button("mod");
        max = new Button("max");
        ans = new TextField("Answer");
        ans.getStyle().set("width", "30em");
        ans.setEnabled(false);
        HorizontalLayout layout = new HorizontalLayout();
        layout.add(sum);
        layout.add(minus);
        layout.add(mul);
        layout.add(div);
        layout.add(mod);
        layout.add(max);
        sum.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/plus/"+num1+"/"+num2)
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(String.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            ans.setValue(out);
        });
        minus.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/minus/"+num1+"/"+num2)
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(String.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            ans.setValue(out);
        });
        mul.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/multi/"+num1+"/"+num2)
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(String.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            ans.setValue(out);
        });
        div.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/divide/"+num1+"/"+num2)
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(String.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            ans.setValue(out);
        });
        mod.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/mod/"+num1+"/"+num2)
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(String.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            ans.setValue(out);
        });
        max.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .body(Mono.just(new MyNumber(num1, num2)), MyNumber.class)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });
        setMargin(true);
        add(n1, n2, text, layout, ans);
    }

}