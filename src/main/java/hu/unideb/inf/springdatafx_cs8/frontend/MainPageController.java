package hu.unideb.inf.springdatafx_cs8.frontend;

import hu.unideb.inf.springdatafx_cs8.SpringDataFxCs8Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class MainPageController {

    public Label nameLabel;
    ConfigurableApplicationContext ctx;

    public void startBackend(ActionEvent actionEvent) {
        ctx = SpringApplication.run(SpringDataFxCs8Application.class);
    }

    public void printData(ActionEvent actionEvent) {
        SpringDataFxCs8Application app =
                ctx.getBean(SpringDataFxCs8Application.class);
        app.printData();
        System.out.println("Printing on frontend: " + app.getPerson());
        nameLabel.setText(app.getPerson().getName());
    }

    public void stopBackend(ActionEvent actionEvent) {
        ctx.close();
    }
}
