package com.stock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChartApp extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Stock Analysis Charts");

        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = StockAnalyzer.calculateSpan(prices);

        // Line Chart: Stock Prices
        NumberAxis xAxis1 = new NumberAxis();
        NumberAxis yAxis1 = new NumberAxis();
        LineChart<Number, Number> priceChart = new LineChart<>(xAxis1, yAxis1);
        priceChart.setTitle("Stock Prices");
        XYChart.Series<Number, Number> priceSeries = new XYChart.Series<>();
        priceSeries.setName("Price");

        for (int i = 0; i < prices.length; i++) {
            priceSeries.getData().add(new XYChart.Data<>(i + 1, prices[i]));
        }

        priceChart.getData().add(priceSeries);

        // Bar Chart: Span
        CategoryAxis xAxis2 = new CategoryAxis();
        NumberAxis yAxis2 = new NumberAxis();
        BarChart<String, Number> spanChart = new BarChart<>(xAxis2, yAxis2);
        spanChart.setTitle("Stock Span");
        XYChart.Series<String, Number> spanSeries = new XYChart.Series<>();
        spanSeries.setName("Span");

        for (int i = 0; i < span.length; i++) {
            spanSeries.getData().add(new XYChart.Data<>("Day " + (i + 1), span[i]));
        }

        spanChart.getData().add(spanSeries);

        VBox vbox = new VBox(priceChart, spanChart);
        Scene scene = new Scene(vbox, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
