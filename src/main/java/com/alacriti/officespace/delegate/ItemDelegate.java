package com.alacriti.officespace.delegate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.alacriti.officespace.bo.ItemBo;
import com.alacriti.officespace.util.DbConnection;
import com.alacriti.officespace.vo.ItemDetailsAdmin;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class ItemDelegate {
	public static ItemDetailsAdmin getItemDetails(int itemId) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException, SQLException{
		Connection connection = DbConnection.getConnection();
		return ItemBo.getItemDetails(connection,itemId);
	}
}
