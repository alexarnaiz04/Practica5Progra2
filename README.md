# Implementación de un Grafo en Java

## Introducción

Este proyecto implementa un grafo dirigido usando una lista de adyacencia en Java. Un grafo es una estructura que conecta objetos (vértices) mediante relaciones (arcos o aristas).

## Descripción General

El programa está contenido en una clase llamada Graph, que permite:

Añadir vértices.
Añadir arcos entre vértices.
Obtener los vértices adyacentes a un vértice dado.
Verificar si un vértice está en el grafo.
Encontrar el camino más corto entre dos vértices.

## Componentes del Código

### Atributo Principal
adjacencyList: Un mapa que asocia cada vértice con un conjunto de sus vértices adyacentes.

### Métodos Principales
Añadir Vértices:
addVertex(V v): Añade un nuevo vértice al grafo si no existe ya.

Añadir Arcos:
addEdge(V v1, V v2): Añade un arco del vértice v1 al vértice v2. Si alguno de los vértices no existe, lo añade.

Obtener Adyacentes:
obtainAdjacents(V v): Devuelve los vértices adyacentes a v.

Verificar Vértices:
containsVertex(V v): Comprueba si el vértice v está en el grafo.

Representación del Grafo:
toString(): Devuelve una cadena que representa la lista de adyacencia del grafo.

Camino Más Corto:
shortestPath(V v1, V v2): Encuentra el camino más corto entre v1 y v2 utilizando el algoritmo de búsqueda en anchura (BFS).

## Funcionamiento Básico
Agregar Vértices y Arcos: Se pueden agregar vértices y arcos entre ellos, formando así las conexiones en el grafo.
Obtener Adyacentes y Verificar Vértices: Permite verificar las conexiones y la existencia de vértices en el grafo.
Camino Más Corto: Utiliza BFS para encontrar el camino más corto entre dos vértices, si existe.

## Autor
Este proyecto fue desarrollado por Alejandro Arnaiz Garrido

## Comandos maven
Para compilar: mvn compile
Para el paquete: mvn package 
Para ejecutar el test y verificar que el codigo funcona correctamente: mvn test
