# Coordinate-Convertor
Geocoding: converting addresses (like a street address) into geographic coordinates through amap API service

# Convertor class
Contains main method, call functions to create a JSON file 

# FileIO class
Reads from a xlsx file and create an ArrayList of Station objects; Write ArrayList of Station objects to a JSON file

# Coordinate class
Converts address into geographic coordinates by HTTP GET request through amap API service

# DTO class
Creates Station object and object ArrayList

# Station class
Stations object which has station name, longitude, latitude, count info

# Keys class (private)
Contains API key, input/output file location
