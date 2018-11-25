/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.util.Iterator;
import javax.swing.JPanel;
import model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Usuario
 */
public class HistogramDisplay extends ApplicationFrame{
    
    private final Histogram <String> histogram;
    
    public HistogramDisplay(Histogram <String> histogram) {
        super("Histograma");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    
    public void execute(){
        setVisible(true);
    }
    
    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){       
        JFreeChart chart = ChartFactory.createBarChart3D( "Histograma JFreeChart",
                "Dominios email", "Nยบ de emails", dataSet, PlotOrientation.VERTICAL,
                rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for (String key : histogram.keySet()){
            dataSet.addValue(histogram.get(key), "", key);
        }        
        return dataSet;
    }
}
