import csv
import math


matriz = [[]]
keys = []


def haversine(lon1, lat1, lon2, lat2):
    # convert decimal degrees to radians 
    lon1, lat1, lon2, lat2 = map(math.radians, [lon1, lat1, lon2, lat2])
    # haversine formula 
    dlon = lon2 - lon1 
    dlat = lat2 - lat1 
    a = math.sin(dlat/2)**2 + math.cos(lat1) * math.cos(lat2) * math.sin(dlon/2)**2
    c = 2 * math.asin(math.sqrt(a)) 
    km = 6367 * c
    return km

def tam (n):
    matriz = [[]*n] * n


def build (nodos):
    aux = [nodos]
  
    for i in range (len(keys)):
        y1 = float(nodos[keys[i]][0])
        x1 = float(nodos[keys[i]][1])
        
        for j  in  range(len(keys)):
            # print(len(nodos), len(matriz))    
            y2 = float(nodos[keys[j]][0])
            x2 = float(nodos[keys[j]][1])
            puntos = haversine(x1,y1,x2,y2)
            puntos = puntos * 1000      
            matriz [i][j] = puntos
            
            
            
    
    return matriz             
   

def read():
    nodos = {}
    with open("medellin_colombia-grande.txt") as f:
         data = f.readlines()

    for line in data:
        words = line.split()
        nodos[words[0]] = (words[1],words[2])
        keys.append(words[0])    
      
    return nodos
    


if __name__ == "__main__": 
   nodos = read()
   matriz = [[None] * len(nodos) for i in range(len(nodos))]
   
     
   build(nodos)
   print(matriz)
   
   
   
   