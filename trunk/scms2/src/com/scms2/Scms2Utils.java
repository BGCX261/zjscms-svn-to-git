package com.scms2;

import com.thoughtworks.xstream.XStream;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.util.List;
import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.SystemUtils;
import javax.imageio.ImageIO; 

/**
 * 系统工具类
 * @author Zhujing
 */
public class Scms2Utils {

    /**
     * 装载一个图片对象
     */
    public static Image getFrameIconImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("Butterfly_32x32.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * 判断字符串是否为空
     */
    public static boolean isNull(String parStr) {
        return StringUtils.isBlank(parStr);
    }

    /**
     * 清楚字符串的空格
     */
    public static String trim(String parStr) {
        return StringUtils.trimToEmpty(parStr);
    }

    /**
     * 获得用户路径
     */
    public static String getUserDir() {
        return SystemUtils.getUserDir().getPath();
    }

    /**
     * 读取文件
     */
    public static String readFile(String parFile) {
        String str = null;
        try {
            str = FileUtils.readFileToString(new File(parFile));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return str;
    }

    /**
     * 写入文件
     */
    public static void writeFile(String parStr, String parFile) {
        try {
            FileUtils.writeStringToFile(new File(parFile), parStr);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 将材料对象存储到XML文件中
     */
    public static void materialToXML(MaterialsBean mb) {
        XStream xstream = new XStream();
        xstream.alias("materials", MaterialsBean.class);
        xstream.alias("part", PartBean.class);
        String xml = xstream.toXML(mb);
        xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + xml;
        Scms2Utils.writeFile(xml, SystemInfo.MATERIALS_XML);
    }

    /**
     * 将产品对象存储到XML中
     */
    public static void productsToXML(ProductsBean pb) {
        XStream xstream = new XStream();
        xstream.alias("products", ProductsBean.class);
        xstream.alias("computer", ComputerBean.class);
        String xml = xstream.toXML(pb);
        xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + xml;
        Scms2Utils.writeFile(xml, SystemInfo.PRODUCTS_XML);
    }

    /**
     * 查询出材料信息
     */
    public static MaterialsBean queryMaterials() {
        MaterialsBean mb = null;
        try {
            XStream xstream = new XStream();
            xstream.alias("materials", MaterialsBean.class);
            xstream.alias("part", PartBean.class);
            mb = (MaterialsBean)xstream.fromXML(new FileReader(SystemInfo.MATERIALS_XML));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return mb;
    }

    /**
     * 查询出产品信息
     */
    public static ProductsBean queryProducts() {
        ProductsBean pb = null;
        try {
            XStream xstream = new XStream();
            xstream.alias("products", ProductsBean.class);
            xstream.alias("computer", ComputerBean.class);
            pb = (ProductsBean)xstream.fromXML(new FileReader(SystemInfo.PRODUCTS_XML));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return pb;
    }

    /**
     * 将查询出的茶品信息显示到列表组件中
     */
    public static void fillProductsTable(JTable parJTable) {
        parJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn column = parJTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(50);
        column = parJTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(90);
        column = parJTable.getColumnModel().getColumn(2);
        column.setPreferredWidth(130);
        column = parJTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(170);
        DefaultTableModel dtm = (DefaultTableModel)parJTable.getModel();
        dtm.setRowCount(0);
        ProductsBean pb = queryProducts();
        List<ComputerBean> computerList = pb.getComputerList();
        Object[] objArray = null;
        for (ComputerBean cb : computerList) {
            objArray = new Object[4];
            objArray[0] = cb.getNumber();
            objArray[1] = cb.getName();
            objArray[2] = cb.getComment();
            objArray[3] = cb.getComponent();
            dtm.addRow(objArray);
        }
    }

    /**
     * 将查询出来的产品详细信息显示到列表组件中
     */
    public static void fillProductsDetailTable (JTable parJTable) {
        parJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn column = parJTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(60);
        column = parJTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(100);
        column = parJTable.getColumnModel().getColumn(2);
        column.setPreferredWidth(150);
        column = parJTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(150);
        DefaultTableModel dtm = (DefaultTableModel)parJTable.getModel();
        dtm.setRowCount(0);
        ProductsBean pb = queryProducts();
        MaterialsBean mb = queryMaterials();
        List<ComputerBean> computerList = pb.getComputerList();
        List<PartBean> partList = mb.getPartList();
        Object[] objArray = null;
        String[] tempComponentArray = null;
        for (ComputerBean cb : computerList) {
            objArray = new Object[4];
            objArray[0] = cb.getNumber();
            objArray[1] = cb.getName();
            objArray[2] = cb.getComment();
            objArray[3] = "";
            dtm.addRow(objArray);
            tempComponentArray = cb.getComponent().split(",");
            for (String comp : tempComponentArray) {
                for (PartBean tb : partList) {
                    if (comp.equals(tb.getNumber())) {
                        objArray = new Object[4];
                        objArray[0] = "  ---->";
                        objArray[1] = tb.getNumber();
                        objArray[2] = tb.getName();
                        objArray[3] = tb.getComment();
                        dtm.addRow(objArray);
                    }
                }
            }
        }
    }

    /**
     * 将查询出来的材料信息显示到列表组件中
     */
    public static void fillMaterialsTable(JTable parJTable) {
        parJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn column = parJTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(50);
        column = parJTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(160);
        column = parJTable.getColumnModel().getColumn(2);
        column.setPreferredWidth(100);
        column = parJTable.getColumnModel().getColumn(3);
        column.setPreferredWidth(60);
        DefaultTableModel dtm = (DefaultTableModel)parJTable.getModel();
        dtm.setRowCount(0);
        MaterialsBean mb = queryMaterials();
        List<PartBean> partList = mb.getPartList();
        Object[] objArray = null;
        for (PartBean tb : partList) {
            objArray = new Object[4];
            objArray[0] = tb.getNumber();
            objArray[1] = tb.getName();
            objArray[2] = tb.getComment();
            objArray[3] = tb.getQuantity();
            dtm.addRow(objArray);
        }
    }
    
}
