from flask import Flask
import MySQLdb
import json

app = Flask(__name__,static_url_path = "")

@app.route('/add/<int:x>&<int:y>', methods = ['GET'])
def add(x,y):
	print("result:",str(x+y))
	return str(x+y)

@app.route('/sub/<int:x>&<int:y>', methods = ['GET'])
def sub(x,y):
	print("result:",str(x-y))
	return str(x-y)

@app.route('/mul/<int:x>&<int:y>', methods = ['GET'])
def mul(x,y):
	print("result:",str(x*y))
	return str(x*y)

@app.route('/div/<int:x>&<int:y>', methods = ['GET'])
def div(x,y):
	if y == 0:
		return 'Divide by Zero not permitted'
	print("result:",str(x/y))
	return str(x/y)

@app.route('/getS/<string:x>', methods = ['GET'])
def GetStudent(x):
	db = MySQLdb.connect("127.0.0.1","root","deepak123","dk");
	cursor = db.cursor()
	j = json.loads(x)
	x = j["a"]
	query = "select * from students where rollno=%d"%(x);
	try:
		cursor.execute(query)
		res = cursor.fetchall()
		for row in res:
			return (str(row[1]));
	except Exception as e:
		raise e


@app.route('/delS/<string:x>', methods = ['GET'])
def DelStudent(x):
	db = MySQLdb.connect("127.0.0.1","root","deepak123","dk");
	cursor = db.cursor()
	j = json.loads(x)
	x = j["a"]
	query = "delete from students where rollno=%d"%(x);
	try:
		cursor.execute(query)
		db.commit()
		return "Done"
	except Exception as e:
		raise e


@app.route('/updS/<string:x>', methods = ['GET'])
def UpdStudent(x):
	db = MySQLdb.connect("127.0.0.1","root","deepak123","dk");
	cursor = db.cursor()
	j = json.loads(x)
	rollno = j["a"]
	name = j["b"]
	query = "update students set name='%s' where rollno=%d"%(name, rollno);
	try:
		cursor.execute(query)
		db.commit()
		return "Done"
	except Exception as e:
		raise e


@app.route('/crtS/<string:x>', methods = ['GET'])
def CreateStudent(x):
	db = MySQLdb.connect("127.0.0.1","root","deepak123","dk");
	cursor = db.cursor()
	j = json.loads(x)
	rollno = j["a"]
	name = j["b"]
	print(name)
	query = "insert into students(rollno,name) values(%d,'%s')"%(rollno,name);
	try:
		cursor.execute(query)
		db.commit()
		return "Done"
	except Exception as e:
		raise e



if __name__ == '__main__':
	app.run(host='127.0.0.1',debug = True)
