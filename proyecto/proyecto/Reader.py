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
    
    

  
    for l in nodos:
        i = 0
        s = 0
        y1 = float(nodos[l][0])
        x1 = float(nodos[l][1])
        
        for j  in  nodos:
            
            y2 = float(nodos[j][0])
            x2 = float(nodos[j][1])
            puntos = haversine(x1,y1,x2,y2)
            puntos = puntos * 1000
            print(puntos)
           # matriz [int(l)][int(j)] = puntos
            s + 1
            
            
               
            
        i + 1  
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
   matriz = [[]*len(nodos)] * len(nodos)
   build(nodos)
   
   
   
   