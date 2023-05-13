package BLL;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.DAOBill;
import DTO.Bill;

public class BLLBill {
	private static BLLBill instance;
	public static BLLBill Instance() {
		if(instance == null)
			instance = new BLLBill();
		return instance;
	}
	private BLLBill() {
		
	}
	public void insert(int iDCustomer, int iDcourse, int iDuser,int total) {
		LocalDate date = LocalDate.now();
		Bill bill = new Bill(iDCustomer,iDcourse,iDuser,total);
		int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm hóa đơn này?",null,JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			try {
				if(DAOBill.Instance().insert(bill) > 0)
					JOptionPane.showMessageDialog(null, "Thêm hóa đơn thành công");
				else
					JOptionPane.showConfirmDialog(null, "Thêm hóa đơn thất bại");
			} catch (HeadlessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void update(int id, int idcustomer,int idcourse,int iduser,LocalDate date,int total) {
		Bill bill = new Bill(id,idcustomer,idcourse,iduser,date,total);
		int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật hóa đơn này?",null,JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			try {
				if(DAOBill.Instance().update(bill) > 0)
					JOptionPane.showMessageDialog(null, "Cập nhật hóa đơn thành công");
				else
					JOptionPane.showConfirmDialog(null, "Cập nhật hóa đơn thất bại");
			} catch (HeadlessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void delete(int id) {
		int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa hóa đơn này?",null,JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			try {
				if(DAOBill.Instance().delete(id) > 0)
					JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công");
				else
					JOptionPane.showConfirmDialog(null, "Xóa nhật hóa đơn thất bại");
			} catch (HeadlessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Bill selectById(int id) throws ClassNotFoundException, SQLException {
		return DAOBill.Instance().selectByID(id);
	}
	public ArrayList<Bill> selectAll() throws ClassNotFoundException, SQLException{
		return DAOBill.Instance().selectAll();
	}
}
