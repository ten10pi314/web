from flask import Flask
import MySQLdb
from flask_spyne import Spyne
from spyne.protocol.soap import Soap11
from spyne.model.primitive import Integer, String

app = Flask(__name__)
spyne = Spyne(app)

class SomeSoapService(spyne.Service):
	__service_url_path__ = '/soap/calculator'
	__in_protocol__ = Soap11(validator='lxml')
	__out_protocol__ = Soap11()

	
	@spyne.srpc(String, _returns=String)
	def getStudent(rollno):
		db = MySQLdb.connect("127.0.0.1","root","deepak123","dk");
		cursor = db.cursor()
		x = int(rollno)
		query = "select * from students where rollno=%d"%(x);
		try:
			cursor.execute(query)
			res = cursor.fetchall()
			for row in res:
				return (str(row[1]));
		except Exception as e:
			raise e

	@spyne.srpc(String, String, _returns=String)
	def updateStudent(rollno,name):
		db = MySQLdb.connect("127.0.0.1","root","deepak123","dk");
		cursor = db.cursor()
		x = int(rollno)
		query = "update students set name='%s' where rollno=%d"%(name,x);
		try:
			cursor.execute(query)
			db.commit()
			return "Done"
		except Exception as e:
			raise e

	@spyne.srpc(String, _returns=String)
	def delStudent(rollno):
		db = MySQLdb.connect("127.0.0.1","root","deepak123","dk");
		cursor = db.cursor()
		x = int(rollno)
		query = "delete from students where rollno=%d"%(x);
		try:
			cursor.execute(query)
			db.commit()
			return "Done"
		except Exception as e:
			raise e

	@spyne.srpc(String, String, _returns=String)
	def insertStudent(rollno,name):
		db = MySQLdb.connect("127.0.0.1","root","deepak123","dk");
		cursor = db.cursor()
		x = int(rollno)
	 	query = "insert into students(rollno,name) values(%d,'%s')"%(x,name);
		try:
			cursor.execute(query)
			db.commit()
			return "Done"
		except Exception as e:
			raise e
	
	@spyne.srpc(String, String, _returns=String)
	def div(x,y):
		x = int(x)
		y = int(y)	
		if y == 0:
			return 'Divide by Zero not permitted'
		return str(x/y)



if __name__ == '__main__':
	app.run(host='127.0.0.1', debug = True)
