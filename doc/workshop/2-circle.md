# 2. Create a Codecheck.io assignment on your own 

Let's work on this together!

| Step | Instructions |
| --- | --- |
| Complete a solution for `Circle.java` | <ol><li>Implement all methods in `CircleI.java` interface (see [problem](https://psb-david-petty.github.io/2022-csta/src/2-Circle/problem.html)). |
| Complete `Generate.java` to generate test data | <ol><li>Add some test `Circle`s. <li>Generate area test data. <li>Generate point test data. |
| Complete `CircleTest.java` | <ol><li>Add generated test data. <li>Complete `testArea()` and `testPoints()` unit tests. <li>How would you add test(s) for the constructor(s)?|

## Solution(s)

Possible missing code from `Circle.java` is below. 

```Java
//HIDE
    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getR() { return r; }

    public double area() {
        return Math.PI * r * r;
    }
    public boolean isOn(double x, double y) {
        final double dx = this.x - x, dy = this.y - y, eps = r / TOLERANCE;
        double d = Math.sqrt(dx * dx + dy * dy);
        return Math.abs(d - r) <= eps;
    }

    //EDIT // Add your code that implements CircleI
```

Possible missing code from `Generate.java` is below. 

```Java
//HIDE
        circles.add(new Circle(0, 0, 10));
        circles.add(new Circle(100, 100, 100));
        circles.add(new Circle(3, 4, 5));

        // Generate area test data
        for (Circle circle: circles) {
            areas.add(Math.round(circle.area() * Circle.TOLERANCE) / Circle.TOLERANCE);
        }

        // Generate isOn test data.
        double[][] points = new double[circles.size()][];
        List<Boolean> isOns = new ArrayList<Boolean>();
        int sign = 1;
        for (int i = 0; i < circles.size(); i++) {
            Circle circle = circles.get(i);
            double x = circle.getX(), y = circle.getY(), r = circle.getR();
            double eps = sign * r / Circle.TOLERANCE * 0.99;
            if (sign > 0)
                x = x + sign * r + eps;
            else
                y = y + sign * r + eps;
            points[i] = new double[] { x, y, };
            isOns.add(circle.isOn(x, y));
            sign *= -1;
        }

        //EDIT // Add your code that generates test data
```

Possible missing code from `CircleTest.java` is below. 

```Java
    @Test
    public void testArea() {
        assert circles.length == areas.length;
        System.out.printf("%s\n", Feedback.formatBanner("testArea"));
        for (int i = 0; i < circles.length; i++) {
 //HIDE
            Circle circle = circles[i];
            double area = areas[i];
            System.out.printf("(%s).area() \u2192 %.5e\n",
                circle.repr(), circle.area());
            Assert.assertEquals(String.format("(%s).area()", circle.repr()),
                area, circle.area(), area / Circle.TOLERANCE);
            //EDIT // Give feedback on area and use method from Assert to test.
        }
    }

    @Test
    public void testPoints() {
        assert circles.length == points.length;
        assert circles.length == isOns.length;
        System.out.printf("%s\n", Feedback.formatBanner("testPoints"));
        for (int i = 0; i < circles.length; i++) {
//HIDE
            Circle circle = circles[i];
            double x = points[i][0], y = points[i][1];
            System.out.printf("(%s).isOn(%s,%s) \u2192 %s\n",
                circle.repr(), x, y, circle.isOn(x, y));
            Assert.assertEquals(String.format("(%s).isOn(%s,%s)", circle.repr(), x, y),
                isOns[i], circle.isOn(x, y));
            //EDIT // Give feedback on isOn and use method from Assert to test.
        }
    }
```

<hr>

[&#8617; back](https://psb-david-petty.github.io/2022-csta/doc/), [&#128279; permalink](https://psb-david-petty.github.io/2022-csta/doc/workshop/2-circle.html), and [&#128297; repository](https://github.com/psb-david-petty/2022-csta/blob/main/doc/workshop/2-circle.md) for this page.
