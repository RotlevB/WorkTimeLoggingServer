import requests
import json

# define the base URL for the server
base_url = "http://localhost:8080"

# test the /enter endpoint
enter_response = requests.get(base_url + "/enter?id=1")
if enter_response.status_code == 200:
    print("Entrance logged successfully")
else:
    print("Error logging entrance")

# test the /exit endpoint
exit_response = requests.get(base_url + "/exit?id=1")
if exit_response.status_code == 200:
    print("Exit logged successfully")
else:
    print("Error logging exit")

# test the /info endpoint
info_response = requests.get(base_url + "/info?id=1")
if info_response.status_code == 200:
    employee_data = json.loads(info_response.text)
    print(f"Employee data: {employee_data}")
else:
    print("Error retrieving employee data")
    
# test the /info endpoint without an ID
info_all_response = requests.get(base_url + "/info")
if info_all_response.status_code == 200:
    employee_data = json.loads(info_all_response.text)
    print(f"All employee data: {employee_data}")
else:
    print("Error retrieving all employee data")
