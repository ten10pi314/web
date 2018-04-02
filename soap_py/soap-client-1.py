from suds.client import Client as SudsClient

url = 'http://127.0.0.1:5000/soap/calculator?wsdl'
client = SudsClient(url=url, cache=None)
r = client.service.updateStudent("3009","deepakgdk")
print(r)
