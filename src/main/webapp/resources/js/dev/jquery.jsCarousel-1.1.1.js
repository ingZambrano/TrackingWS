
(function ($)
{
    var globals =
    {
        settings: null
        , interval: null
        , counter: 0
        , loaded: false
    };

    var callbacks =
    {
        onLoad: null
    };

    var methods =
    {
        // This method inits the jsCarousel
        _init: function (options)
        {
            var _this = this;

            // Extends settings with passed options
            globals.settings = $.extend({
                interval: 1000
                , autoStart: true
                , direction: 1
                , effect: 'simple'
                , effectDuration: 500
                , width: 'auto'
                , height: 'auto'
            }, options);

            return this.each(function ()
            {
                var el = $(this);
                var html = '';
                var lis = $('li', el);

                // Transforms the lis in linked images
                lis.each(function (index)
                {
                    var li = $(this);

                    if (index > 0)
                    {
                        li.hide();
                    }

                    var a = $('a', li);

                    var img = $(methods._stringFormat('<img src="{src}" alt="{title}"/><br>',
                    		
                        {                    	
                            src: a.data('image')
                            , alt: a.attr('title')
                            
                        }));                    
                    a.html(img);
                });

                // Sets some CSS to the ul
                el.css({
                    'display': 'block'
                    , 'margin': 0
                    , 'padding': 0
                    , 'width': globals.settings.width
                    , 'height': globals.settings.height
                    , 'border': 0
                });

                // Wait for the images to be loaded
                var loadedImages = 0;
                var images = $('img', el);
                images.load(function ()
                {
                    loadedImages++;

                    if (loadedImages == images.size())
                    {
                        globals.loaded = true;

                        // If autostart is enabled, starts the carousel
                        if (globals.settings.autoStart)
                        {
                            methods._start(_this);
                        }

                        // If the onLoad callback has a value, call it
                        if (typeof (callbacks.onLoad) == 'function')
                        {
                            callbacks.onLoad();
                        }
                    }
                });
            });
        }
        // This method starts the carousel
        , start: function ()
        {
            return methods._start(this);
        }
        , _start: function (_this)
        {
            if (globals.loaded)
            {
                if ($('li', _this).size() > 1)
                {
                    globals.interval = window.setInterval(
                        function ()
                        {
                            methods._next(_this);
                        }
                        , globals.settings.interval);
                }
            }
            else
            {
                globals.settings.autoStart = true;
            }

            return _this;
        }
        // This method stops the carousel
        , stop: function (interval)
        {
            return methods._stop(this);
        }
        , _stop: function (_this)
        {
            window.clearInterval(globals.interval);

            return _this;
        }
        // This method moves to the next image
        , next: function ()
        {
            return methods._next(this);
        }
        , _next: function (_this)
        {
            return _this.each(function ()
            {
                var el = $(this);
                var lis = $('li', el);
                var size = lis.size();

                var current = (globals.counter + size) % size;
                globals.counter += globals.settings.direction;
                var next = (globals.counter + size) % size;

                methods._applyEffect(lis, current, next);
            });
        }
        // This method moves to the previous image
        , previous: function ()
        {
            return methods._previous(this)
        }
        , _previous: function (_this)
        {
            globals.settings.direction *= -1;
            methods._next(_this);
            globals.settings.direction *= -1;

            return _this;
        }
        // This method adds a callback
        , addCallback: function (name, callback)
        {
            return methods._addCallback(this, name, callback);
        }
        , _addCallback: function (_this, name, callback)
        {
            callbacks[name] = callback;

            return _this;
        }
        // This method removes a callback
        , removeCallback: function (name)
        {
            return methods._removeCallback(this, name);
        }
        , _removeCallback: function (_this, name)
        {
            callbacks[name] = null;

            return _this;
        }
        // This method returns the current options, and allows to change the values
        , options: function (opt)
        {
            return methods._options(this, opt);
        }
        , _options: function (_this, opt)
        {
            globals.settings = $.extend(
                globals.settings
                , (opt) ? opt : {});

            // This will reset the interval
            methods._stop(_this);
            methods._start(_this);

            return globals.settings;
        }
        , _stringFormat: function (string, values)
        {
            for (var i in values)
            {
                var expresion = new RegExp('\\{' + (i) + '\\}', 'ig');
                string = string.replace(expresion, values[i]);
            }

            return string;
        }
        , _applyEffect: function (lis, current, next)
        {
            if (globals.settings.effect === 'simple')
            {
                methods._applySimpleEffect(lis, current, next);
            }
            else if (globals.settings.effect === 'fade')
            {
                methods._applyFadeEffect(lis, current, next);
            }
            else if (globals.settings.effect === 'slide')
            {
                methods._applySlideEffect(lis, current, next);
            }
        }
        , _applySimpleEffect: function (lis, current, next)
        {
            $(lis[current]).css(
            {
                'display': 'none'
            });

            $(lis[next]).css(
            {
                'display': 'list-item'
            });
        }
        , _applyFadeEffect: function (lis, current, next)
        {
            $(lis[current]).parent().css({
                'position': 'relative'
            });

            $(lis[current]).css({
                'position': 'absolute'
                , 'top': '0'
                , 'left': '0'
                , 'z-index': '2'
                , 'display': 'list-item'
            });

            $(lis[next]).css({
                'position': 'absolute'
                , 'top': '0'
                , 'left': '0'
                , 'z-index': '1'
                , 'display': 'list-item'
            });

            $(lis[current]).fadeOut(globals.settings.effectDuration);
        }
        , _applySlideEffect: function (lis, current, next)
        {
            $(lis[current]).parent().css({
                'position': 'relative'
            });

            $(lis[current]).css({
                'position': 'absolute'
                , 'top': '0'
                , 'left': '0'
                , 'z-index': '2'
                , 'display': 'list-item'
            });

            $(lis[next]).css({
                'position': 'absolute'
                , 'top': '0'
                , 'left': '0'
                , 'z-index': '1'
                , 'display': 'list-item'
            });

            $(lis[current]).slideUp(globals.settings.effectDuration);
        }
        , _isPublic: function (method)
        {
            return method.charAt(0) != '_';
        }
    };

    $.fn.jsCarousel = function (method)
    {
        // Call the method if exists.
        if (methods[method] && methods._isPublic(method))
        {
            return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        }
        else if (typeof method === 'object' || !method)
        {
            return methods._init.apply(this, arguments);
        }
        else
        {
            $.error('Method ' + method + ' does not exist on jQuery.jsCarousel');
        }
    }
})(jQuery);