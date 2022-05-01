package uo.ri.cws.application.business.util.command;

import java.sql.Connection;
import java.sql.SQLException;

import alb.util.jdbc.Jdbc;
import uo.ri.cws.application.business.BusinessException;
import uo.ri.cws.application.persistence.PersistenceException;

public class CommandExecutor {

	public <T> T execute(Command<T> cmd) throws BusinessException, PersistenceException {
		Connection c = null;
		try {
			try {
				c = Jdbc.createThreadConnection();
				c.setAutoCommit(false);

				T res = cmd.execute();
				
				c.commit();
				
				return res;

			} catch (BusinessException e) {
				c.rollback();
				throw e;
			}
		} catch (SQLException e ) {
			throw new PersistenceException(e);
		} finally {
			Jdbc.close(c);
		}
		
	}

}