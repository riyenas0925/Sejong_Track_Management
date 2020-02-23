<html>
<head>
    <style>
        $loader-color: #FF0068;
        $loader-size: 100px;
        $blob-size: 56px;
        $canvas-size: 190px;
        $canvas-padding: 24px;

        $ease-in: cubic-bezier(0.02, 0.01, 0.21, 1);
        $ease-out: cubic-bezier(0.3, 0.27, 0.07, 1.64);

        html, body {
            width: 100%;
            height: 100%;
        }

        body {
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #fff;
        }

        .Loader {
            width: $canvas-size;
            height: $canvas-size;
            position: relative;
            padding: $canvas-padding;

            filter:url("#tooltip-filter");
            transform: rotate(0deg);
            animation: rotate 5s forwards infinite linear;
        }

        .Loader-circle,
        .Loader-blob {
            position: absolute;
        }

        .Loader-circle {
            width: $loader-size;
            height: $loader-size;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            border-radius: 50%;
            background-color: $loader-color;
        }

        .Loader-blob {
            width: $blob-size;
            height: $blob-size;
            bottom: $canvas-padding;
            left: $canvas-padding;
            animation: xAxis 2.5s infinite $ease-in;
        }

        .Loader-blob::after {
            content:'';
            display: block;
            width: 100%;
            height: 100%;
            background-color: $loader-color;
            border-radius: 50%;
            position: absolute;
            animation: yAxis 2.5s infinite $ease-out alternate;
        }
        .Loader-blob::before {
            content:'';
            display: block;
            width: 100%;
            height: 100%;
            background-color: $loader-color;
            border-radius: 50%;
            position: absolute;
            animation: yAxis 2.5s infinite $ease-out 2.5s;
        }

        @keyframes xAxis {
            50% {
                animation-timing-function: $ease-in;
                transform: translateX($canvas-size - $blob-size);
            }
        }

        @keyframes yAxis {
            50% {
                animation-timing-function: $ease-out;
                transform: translateY(-($canvas-size - $blob-size));
            }
        }

        @keyframes rotate {
            100% {
                transform: rotate(360deg);
            }
        }
    </style>
</head>

<body>
<div class="Loader">
    <div class="Loader-circle"></div>
    <div class="Loader-blob"></div>
</div>

<svg xmlns="http://www.w3.org/2000/svg" version="1.1" style="display: none;">
    <defs>
        <filter id="tooltip-filter">
            <feGaussianBlur in="SourceGraphic" stdDeviation="9" result="blur" />
            <feColorMatrix in="blur" mode="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 19 -9" result="goo" />
            <feComposite in="SourceGraphic" in2="goo" operator="atop"/>
        </filter>
    </defs>
</svg>
</body>
</html>