# Project: Coordinate-Convertor
Converts a xlsx file which contains charging station and count information into JSON format data for (Alibaba Cloud) DataV. The JSON data also contains each charging station's geographic coordinate which is converted through amap API service.

将包含充电站点和数量的xlsx文件，转化为阿里云DataV可视化的JSON数据格式。JSON数据中包含每个充电站的经纬度信息（通过高德地图API服务转换）。

# Convertor class
Contains main method, call functions to create a JSON file 

主class

# FileIO class
Reads from a xlsx file and create an ArrayList of Station objects; Write ArrayList of Station objects to a JSON file

读取xlsx文件并建立包含Station类的ArrayList；讲Station类的ArrayList写入JSON文件

# Coordinate class
Converts address into geographic coordinates by HTTP GET request through amap API service

通过HTTP GET对接高德地图API服务，将地址转换为经纬度

# DTO class
Creates Station object and object ArrayList

创建Station类和ArrayList 

# Station class
Station object which has station name, longitude, latitude, count info

Station类，包含站名，经纬度，和数量

# Keys class (private)
Contains API key, input/output file location

包含API密钥，以读入和输出的文件地址
