# Resolución Numérica de EDOs: Euler y Runge-Kutta de 4.º orden

Actividad de la Unidad 6 de la asignatura **SCC-1017 Métodos Numéricos** (Instituto Tecnológico Superior de Xalapa, Ingeniería en Sistemas Computacionales).

El proyecto implementa en Java dos métodos para resolver problemas de valor inicial y compara cada resultado con la solución analítica exacta, calculando el error absoluto `|y_exacta(x_n) - y_n|` en cada paso.

| Método | Problema de valor inicial | Solución exacta |
|---|---|---|
| Euler | y' = x - y, y(0) = 1, x_final = 0.3 | y(x) = x - 1 + 2e^(-x) |
| Runge-Kutta 4 (RK4) | y' = x + y, y(0) = 1, x_final = 0.3 | y(x) = 2e^x - x - 1 |

## Estructura del proyecto

```
src/
├── MetodoEuler.java        # Actividad 1: método de Euler
└── MetodoRungeKutta.java   # Actividad 2: método de Runge-Kutta de 4.º orden
```

Cada clase define la función de la EDO (`evaluarFuncion`), su solución exacta (`solucionExacta`) y un `main` que usa como criterio de paro el número total de pasos N = (x_final - x0) / h.

## Requerimientos

- JDK 17 o superior (desarrollado en IntelliJ IDEA con OpenJDK 26).
- Git, para clonar el repositorio.
- No requiere librerías externas.

## Cómo clonar, compilar y ejecutar desde la terminal

1. Clonar el repositorio:

```
git clone https://github.com/VictorRuizR/EDOs-Euler-y-Runge-Kutta.git
cd EDOs-Euler-y-Runge-Kutta
```

2. Compilar:

```
javac -d out src/*.java
```

3. Ejecutar cada método:

```
java -cp out MetodoEuler
java -cp out MetodoRungeKutta
```

## Cambiar el tamaño de paso (h)

El tamaño de paso es la variable `h` dentro del método `main` de cada clase (por defecto `0.1`). Para probar otros valores, como `0.05` o `0.01`, se modifica esa línea y se vuelve a compilar y ejecutar.

## Salida esperada con h = 0.1

**Euler**

```
n   x_n   y_n (Euler)   y_exacta   Error absoluto
------------------------------------------------------------------
0   0.0000   1.000000   1.000000   0.000000
1   0.1000   0.900000   0.909675   0.009675
2   0.2000   0.820000   0.837462   0.017462
3   0.3000   0.758000   0.781636   0.023636
```

**RK4**

```
n   x_n   y_n (RK4)   y_exacta   Error absoluto
----------------------------------------------------------------------
0   0.0000   1.00000000   1.00000000   0.00e+00
1   0.1000   1.11034167   1.11034184   1.69e-07
2   0.2000   1.24280514   1.24280552   3.75e-07
3   0.3000   1.39971699   1.39971762   6.21e-07
```

## Autor

Victor Ruiz Ruiz
