package main.java.view.backing;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("lineChartBean")
@ViewScoped
public class LineChartBean implements Serializable {
    private LineChartModel lineModel;

    @PostConstruct
    public void init() {
        lineModel = new LineChartModel();
        LineChartSeries sin = new LineChartSeries();
        LineChartSeries cos = new LineChartSeries();
        sin.setLabel("Sin");
        cos.setLabel("Cos");

        for(int i = 0 ; i < 36 ; i++) {
            sin.set(i * 10, Math.sin(Math.toRadians(i * 10)));
            cos.set(i * 10, Math.cos(Math.toRadians(i * 10)));
        }

        lineModel.addSeries(sin);
        lineModel.addSeries(cos);
        lineModel.setLegendPosition("e");
        Axis y = lineModel.getAxis(AxisType.Y);
        y.setMin(-1);
        y.setMax(1);
        y.setLabel("Value");

        Axis x = lineModel.getAxis(AxisType.X);
        x.setMin(0);
        x.setMax(360);
        x.setTickInterval("10");
        x.setLabel("Degrees");

        lineModel.setTitle("Zoom for Details");
        lineModel.setZoom(true);
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }
}