from flask import Flask, request

app = Flask(__name__,static_url_path = "")


@app.route('/add', methods = ['POST'])
def add():
	data = request.data
	data = str(data,'utf-8')
	print(data,type(data))
	x,y = data.split("&")
	x = int(x)
	y = int(y)
	result = x+y
	print("result:",str(result))
	return str(result)

@app.route('/sub', methods = ['POST'])
def sub():
	data = request.data
	x,y = data.split("&")
	x = int(x)
	y = int(y)
	result = x-y
	print("result:",str(result))
	return str(result)

@app.route('/mul', methods = ['POST'])
def mul():
	data = request.data
	x,y = data.split("&")
	x = int(x)
	y = int(y)
	result = x*y
	print("result:",str(result))
	return str(result)

@app.route('/div', methods = ['POST'])
def div():
	data = request.data
	x,y = data.split("&")
	x = int(x)
	y = int(y)
	if y == 0:
		return 'Divide by Zero not permitted'
	result = x/y
	print("result:",str(result))
	return str(result)

if __name__ == '__main__':
	app.run(host='localhost',debug = True)
