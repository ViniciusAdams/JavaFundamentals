def printInfo(iters, prev_x, df, cur_x, prev_step_size):
        print("Iteration :", iters)
        print("previous x :", prev_x)
        print("gradient df:", df)
        print("current x :", cur_x)
        print("step size :", prev_step_size)
        print()
        cur_x = 5
        # cur_x = 2
        gamma = 0.001 # step size multiplier
        precision = 0.000001
        previous_step_size = 1
        max_iters = 3 # maximum number of iterations
        iters = 0 # iteration counter
        df = lambda x: 6*x**2 + 12*x - 20
        # df = lambda x: 4*x**3 - 40*x
        while previous_step_size > precision and iters < max_iters:
        prev_x = cur_x
        cur_x -= gamma * df(prev_x)
        previous_step_size = abs(cur_x - prev_x)
        iters+=1
        printInfo(iters, prev_x, df(prev_x), cur_x, previous_step_size)
        print("The local minimum occurs at:", cur_x)
        print("Number of iterations used:", iters)
;
        //testing