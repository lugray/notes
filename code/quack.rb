class Mallard
  def quack
    puts 'QUACK!'
  end
end

class Pekin
  def quack
    puts 'quack.'
  end
end

[Mallard.new, Pekin.new].each(&:quack)
