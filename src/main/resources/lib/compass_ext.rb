
require 'sass'
require 'sass/engine'
require 'compass'


class SassCompilerApi

   def initialize()
      @options = Compass.sass_engine_options
   end

   def set key, value
      @options[key.to_sym] = value;
   end

   def setImporterDirectory from
      @options[:importer] = Sass::Importers::Filesystem.new(from);
   end

   def compile(inputString, additionalOptions = {})
      Sass::Engine.new(inputString, @options.merge(additionalOptions)).render
   end

end