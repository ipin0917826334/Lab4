package com.example.lab4;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@PageTitle("Calculator")
@Route(value = "index2")
public class CashierView extends VerticalLayout{
    private TextField change;
    private TextField b1000;
    private TextField b500;
    private TextField b100;
    private TextField b20;
    private TextField b10;
    private TextField b5;
    private TextField b1;
    private Button cal;
    public CashierView() {
        change = new TextField("เงินทอน");
        cal = new Button("คํานวณเงินทอน");
        b1000 = new TextField();
        b1000.setValue("$1000: ");
        b1000.setEnabled(false);
        b500 = new TextField();
        b500.setValue("$500: ");
        b500.setEnabled(false);
        b100 = new TextField();
        b100.setValue("$100: ");
        b100.setEnabled(false);
        b20 = new TextField();
        b20.setValue("$20: ");
        b20.setEnabled(false);
        b10 = new TextField();
        b10.setValue("$10: ");
        b10.setEnabled(false);
        b5 = new TextField();
        b5.setValue("$5: ");
        b5.setEnabled(false);
        b1 = new TextField();
        b1.setValue("$1: ");
        b1.setEnabled(false);
        setMargin(true);
        add(change, cal, b1000, b500, b100, b20, b10, b5, b1);
        cal.addClickListener(event ->{
            int change1 = Integer.parseInt(change.getValue());
            Change out = WebClient.create()
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/getChange/"+change1)
                    .retrieve() // ให้รอรับข้อมูลกลับมา
                    .bodyToMono(Change.class) // กําหนด Spec ของ Response
                    .block(); // Blocking thread
            b1000.setValue("$1000: "+out.getB1000()+"");
            b500.setValue("$500: "+out.getB500()+"");
            b100.setValue("$100: "+out.getB100()+"");
            b20.setValue("$20: "+out.getB20()+"");
            b10.setValue("$10: "+out.getB10()+"");
            b5.setValue("$5: "+out.getB5()+"");
            b1.setValue("$1: "+out.getB1()+"");
        });
    }
}
