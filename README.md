# Universidad Politecnica Salesiana
# Estructuras no lineales
---
## Nombre:
SEBASTIAN MUÑOZ

## MATERIA:
ESTRUCTURA DE DATOS

## FECHA
22/06/2026

## PROFESOR:
PABLO TORRES

## Árbol Binario de Búsqueda en Java

---

## 1. Descripción General

Este proyecto implementa una estructura de datos de tipo **Árbol Binario de Búsqueda (Binary Search Tree - BST)** en Java. Se incluyen dos implementaciones principales:

- Una versión genérica basada en tipos comparables (`BinaryTree<T extends Comparable<T>>`)
- Una versión específica para valores enteros (`IntTree`)

Ambas estructuras permiten la inserción ordenada de elementos, así como la realización de recorridos clásicos del árbol y el cálculo de propiedades estructurales como altura y peso.

---

## 2. Estructura del Nodo

La clase `Node<T>` representa la unidad básica del árbol.

### Atributos

- `T value`: valor almacenado en el nodo
- `Node<T> left`: referencia al hijo izquierdo
- `Node<T> right`: referencia al hijo derecho

### Características

- Implementación genérica
- Enlace recursivo para estructuras tipo árbol
- No contiene lógica de inserción, únicamente almacenamiento y acceso

### Métodos principales

- Constructor con valor inicial obligatorio
- Getters y setters para valor, hijo izquierdo y derecho
- Método `toString()` para representación del nodo

---

## 3. Árbol Binario Genérico (BinaryTree)

La clase `BinaryTree<T extends Comparable<T>>` implementa un árbol binario de búsqueda genérico.

---

### 3.1 Atributos

- `Node<T> root`: nodo raíz del árbol

---

### 3.2 Inserción de elementos

El método `add(T value)` inserta un nuevo nodo en el árbol utilizando recursividad.

#### Lógica de inserción

- Si el árbol está vacío, el nodo se asigna como raíz
- Si el valor a insertar es menor que el nodo actual, se inserta en el subárbol izquierdo
- Si el valor es mayor o igual, se inserta en el subárbol derecho

La comparación se realiza mediante el método:

- `compareTo()` de la interfaz `Comparable`

---

### 3.3 Recorridos del árbol

Se implementan los tres recorridos estándar:

#### Preorden
Orden:
- Nodo actual
- Subárbol izquierdo
- Subárbol derecho

#### Inorden
Orden:
- Subárbol izquierdo
- Nodo actual
- Subárbol derecho

Este recorrido devuelve los elementos en orden ascendente en un BST.

#### Postorden
Orden:
- Subárbol izquierdo
- Subárbol derecho
- Nodo actual

---

### 3.4 Altura del árbol

El método `getHeight()` calcula la altura del árbol.

Definición:
- Número máximo de niveles desde la raíz hasta una hoja

Implementación:
- Se calcula recursivamente tomando el máximo entre el subárbol izquierdo y derecho

---

### 3.5 Peso del árbol

El método `getPeso()` calcula la cantidad total de nodos.

Definición:
- Número total de nodos presentes en el árbol

Implementación:
- Suma recursiva de todos los nodos del subárbol izquierdo y derecho más el nodo actual

---

## 4. Árbol Binario de Enteros (IntTree)

La clase `IntTree` es una implementación especializada del árbol binario para el tipo `Integer`.

---

### 4.1 Características

- No es genérica
- Utiliza comparación directa con operadores (`>` y `<`)
- Mantiene la misma estructura lógica que el árbol genérico

---

### 4.2 Inserción

El método `add(int value)` inserta valores enteros en el árbol.

Reglas:

- Si el valor es menor al nodo actual, se inserta a la izquierda
- Si el valor es mayor o igual, se inserta a la derecha

---

### 4.3 Recorridos

Implementa los mismos recorridos que el árbol genérico:

- Preorden
- Inorden
- Postorden

---

### 4.4 Altura y peso

Ambos métodos funcionan de forma idéntica al `BinaryTree`:

- `getHeight()`: calcula profundidad máxima del árbol
- `getPeso()`: cuenta total de nodos

---

## 5. Complejidad

### Inserción

- Caso promedio: O(log n)
- Peor caso (árbol degenerado): O(n)

### Recorridos

- Tiempo: O(n)
- Espacio (recursión): O(h), donde h es la altura del árbol

---

## 6. Conceptos aplicados

- Estructuras de datos no lineales
- Árboles binarios de búsqueda (BST)
- Programación genérica en Java
- Recursividad
- Interfaz Comparable
- Análisis de complejidad básica

---

## 7. Observaciones de diseño

- El árbol no está balanceado (no AVL ni Red-Black)
- La eficiencia depende del orden de inserción
- La implementación prioriza simplicidad y claridad académica

---