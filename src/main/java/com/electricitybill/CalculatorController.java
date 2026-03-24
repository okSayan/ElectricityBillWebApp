package com.electricitybill;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// @Controller tells Spring: "This class handles web requests"
@Controller
public class CalculatorController {

    // We create one Calculator object to use for all requests
    private final Calculator calculator = new Calculator();

    // @GetMapping("/") means: when someone visits the homepage, run this method
    @GetMapping("/")
    public String index() {
        return "index"; // loads src/main/resources/templates/index.html
    }

    // @PostMapping("/calculate") means: when the form is submitted, run this
    @PostMapping("/calculate")
    public String calculate(
        @RequestParam int kwh,   // grabs the "kwh" value from the form
        Model model              // Model lets us send data to the HTML page
    ) {
        double bill = calculator.calculateBill(kwh);

        // These become available in HTML as ${kwh} and ${bill}
        model.addAttribute("kwh", kwh);
        model.addAttribute("bill", String.format("%.2f", bill));

        return "index"; // go back to the same page and show the result
    }
}
